package facade;

import java.util.HashMap;
import java.util.Map;

import enums.VehicleType;
import interfaces.IParkingLot;
import interfaces.IParkingLotService;
import interfaces.ITicket;
import models.ParkingLot;

public class AppFacade {
	IParkingLotService parkingLotService;
	public static int ticketId = 1;
	
	public AppFacade(IParkingLotService parkingService){
		this.parkingLotService = parkingService;
	}

	public String createParkingLot(String parkingLotId, int noOfFloors, int noOFSlotsPerFloor){
		IParkingLot parkingLot = this.parkingLotService.createParkingLot(parkingLotId, noOfFloors, noOFSlotsPerFloor);
		if(parkingLot != null) {
			return "create_parking_lot with " +  parkingLot.getFloors() + " floors and " +  parkingLot.getSlotsPerFloor() + " slots per floor.";
		}
		return "";
	}
	
	public String parkVehicle(VehicleType vehicleType, String regNo, String color) {
		
		HashMap<Integer,Integer> map = ParkingLot.getInstance().getNumberOfSlotsLeft().get(vehicleType);
		int i = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 0) {
				i++;
			}
		}
		
		if(i == ParkingLot.getInstance().getFloors()) {
			return "No Parking Available";
		}
		ITicket ticket = this.parkingLotService.parkVehicle(vehicleType, regNo, color);
		ticket.setTicketId(Integer.toString(ticketId));
		return "Parked Vehicle :: Ticket Id :: " + ticket.getTicketId() + " :: Slot Id :: " + ticket.getSlotNumber() + " Floor :: " + ticket.getFloorNumber() ; 
	}
}
