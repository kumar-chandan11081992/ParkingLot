package models;

import interfaces.ITicket;

public class Ticket implements ITicket{
	String parkingLotId;
	String floorNumber;
	String slotNumber;
	String ticketId;
	
	public Ticket(String parkingLotId, String floorNumber, String slotNumber) {
		this.parkingLotId = parkingLotId;
		this.floorNumber = floorNumber;
		this.slotNumber = slotNumber;
	}

	public String getParkingLotId() {
		return parkingLotId;
	}

	public void setParkingLotId(String parkingLotId) {
		this.parkingLotId = parkingLotId;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	@Override
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	
	@Override
	public String getTicketId() {
		return this.ticketId;
	}
	
	
}
