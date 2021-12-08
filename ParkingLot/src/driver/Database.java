package driver;

import java.util.concurrent.ConcurrentHashMap;

import interfaces.IParkingLot;
import interfaces.ITicket;
import interfaces.IVehicle;
import models.ParkingLot;

public class Database {

	private ConcurrentHashMap<Integer, IVehicle> vehicles;
	private ConcurrentHashMap<Integer, ITicket> tickets;
	private static Database db;
	private Database() {
		vehicles = new ConcurrentHashMap<Integer, IVehicle>();
	}
	
	public static Database getInstance() {
		if(db == null) {
			db = new Database();
		}
		
		return db;
	}
	
	public static ConcurrentHashMap<Integer, IVehicle> getVehicles() {
		Database db = Database.getInstance();
		return db.vehicles;
	}
	
	public static ConcurrentHashMap<Integer, ITicket> getTickets() {
		Database db = Database.getInstance();
		return db.tickets;
	}
	
	public static ParkingLot getParkingLot() {
		return ParkingLot.getInstance();
	}
}
