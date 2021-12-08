package services;

import java.util.HashMap;
import java.util.Map;

import enums.VehicleType;
import interfaces.IFloor;
import interfaces.IParkingLot;
import interfaces.IParkingLotService;
import interfaces.ISlot;
import interfaces.ITicket;
import interfaces.ITicketService;
import interfaces.IVehicle;
import interfaces.IVehicleService;
import models.ParkingLot;

public class ParkingLotService implements IParkingLotService{

	IVehicleService vehicleService;
	ITicketService ticketService;
	IParkingLot parkingLot;
	
	public ParkingLotService(IVehicleService vehicleService, ITicketService ticketService) {
		this.vehicleService = vehicleService;
		this.ticketService = ticketService;
	}
	
	@Override
	public IParkingLot createParkingLot(String parkingLotId, int noOfFloors, int noOFSlotsPerFloor) {
		this.parkingLot = ParkingLot.getInstance(parkingLotId, noOfFloors, noOFSlotsPerFloor);
		return this.parkingLot;
	}
	
	@Override
	public ITicket parkVehicle(VehicleType vehicleType, String regNo, String color) {
		IVehicle vehicle = this.vehicleService.createVehicle(vehicleType, regNo, color);
		ISlot slot = this.getSlotInParking(vehicle.getType());
		ITicket ticket = this.ticketService.createTicket(this.parkingLot.getId(), slot.getFloor().getFloorId(), slot.getSlotId());
		return ticket;
	}

	private ISlot getSlotInParking(VehicleType vehicleType) {
		HashMap<Integer,Integer> numberOfSlotsLeftForVehicleType = this.parkingLot.getNumberOfSlotsLeft().get(vehicleType);
		ISlot slot = null;
		for(int i = 1; i< this.parkingLot.getFloors(); i++) {
			
			int slotsLeftForVehicleTypeOnFloor = numberOfSlotsLeftForVehicleType.get(i);
			if(numberOfSlotsLeftForVehicleType.get(i) > 0) {
				numberOfSlotsLeftForVehicleType.put(i, slotsLeftForVehicleTypeOnFloor-1);
				
				IFloor floor = this.parkingLot.getParkingLotMap().get(i);
				for(int j = 1; j < this.parkingLot.getSlotsPerFloor(); j++) {
					slot = floor.getSlots().get(j-1);
					if(slot.getSupportedVehicleType() == vehicleType 
							&& slot.isOccupied() == false) {
						slot.setOccupied(true);
						break;
					}
				}
				
			}
		}
		
		return slot;
	}
}
