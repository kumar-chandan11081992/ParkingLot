package models;

import enums.VehicleType;
import interfaces.IFloor;
import interfaces.ISlot;
import interfaces.IVehicle;

public class Slot implements ISlot{

	public VehicleType supportedVehicleType;
	private IVehicle vehicle;
	private IFloor floor;
	private String SlotId;
	
	public Slot(VehicleType supportedVehicleType, IFloor floor, String slotId){
		this.supportedVehicleType = supportedVehicleType;
		this.floor = floor;
		this.SlotId = slotId;
	}
	
	public String getSlotId() {
		return SlotId;
	}

	public void setSlotId(String slotId) {
		this.SlotId = slotId;
	}

	private boolean occupied = false;
	
	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public VehicleType getSupportedVehicleType() {
		return supportedVehicleType;
	}

	public void setSupportedVehicleType(VehicleType supportedVehicleType) {
		this.supportedVehicleType = supportedVehicleType;
	}

	public IVehicle getVehicle() {
		return vehicle;
	}
	
	public IFloor getFloor() {
		return this.floor;
	}

	public void setVehicle(Vehicle vehicle) {
		if(this.vehicle == null)
			this.vehicle = vehicle;
		else
			throw new IllegalArgumentException("Vehicle already assigned to this Slot.");
	}
}
