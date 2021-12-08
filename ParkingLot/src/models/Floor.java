package models;

import java.util.LinkedList;
import java.util.List;

import interfaces.IFloor;
import interfaces.ISlot;

public class Floor implements IFloor{
	
	String floorId;
	List<ISlot> slots;
	int numOfSlots;
	
	public Floor(String floorId,int numOfSlots){
		this.floorId = floorId;
		this.numOfSlots = numOfSlots;
		this.slots = new LinkedList<>();
	}
	
	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	@Override
	public List<ISlot> getSlots() {
		// TODO Auto-generated method stub
		return this.slots;
	}
	
	@Override
	public void setSlots(List<ISlot> slots) {
	this.slots = slots;	
	}
}
