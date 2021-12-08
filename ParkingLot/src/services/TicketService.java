package services;

import driver.Database;
import interfaces.ITicket;
import interfaces.ITicketService;
import models.Ticket;

public class TicketService implements ITicketService {
	Database db;
	
	public TicketService(Database db){
		this.db = db;
	}
public ITicket createTicket(String parkingLotId, String floorNumber, String SlotNumber) {
	return new Ticket(parkingLotId, floorNumber, SlotNumber);
}
}
