package models;

import enums.VehicleType;
import interfaces.ISlot;
import interfaces.IVehicle;

public class Vehicle implements IVehicle{
	VehicleType type;
	String resitrationNumber;
	String color;
	ISlot slot;
	
	public Vehicle(VehicleType type, String resitrationNumber, String color){
		this.type = type;
		this.resitrationNumber = resitrationNumber;
		this.color = color;
	}
	
	
	public VehicleType getType() {
		return type;
	}


	public void setType(VehicleType type) {
		this.type = type;
	}


	public String getResitrationNumber() {
		return resitrationNumber;
	}


	public void setResitrationNumber(String resitrationNumber) {
		this.resitrationNumber = resitrationNumber;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public ISlot getSlot() {
		return slot;
	}


	public void setSlot(ISlot slot) {
		this.slot = slot;
	}
}
