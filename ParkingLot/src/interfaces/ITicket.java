package interfaces;

public interface ITicket {
	public String getParkingLotId();

	public String getFloorNumber();

	public String getSlotNumber();
	
	public String getTicketId();
	
	public void setTicketId(String ticketId);
}
