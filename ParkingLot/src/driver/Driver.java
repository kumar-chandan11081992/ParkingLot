package driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import enums.VehicleType;
import facade.AppFacade;
import interfaces.IParkingLotService;
import interfaces.ITicketService;
import interfaces.IVehicleService;
import services.ParkingLotService;
import services.TicketService;
import services.VehicleService;

public class Driver {

	public static void main(String[] args) {
		Database db = Database.getInstance();
		IVehicleService vehicleService = new VehicleService();
		ITicketService ticketService = new TicketService(db);
		IParkingLotService parkingService = new ParkingLotService(vehicleService, ticketService);
		AppFacade facade = new AppFacade(parkingService);

		while(true) {
			  Scanner myObj = new Scanner(System.in);  // Create a Scanner object
			  String userInput = myObj.nextLine();
			  
			  if(userInput.equals("exit")) {
				  System.exit(0);
			  }
			  
			  else if(userInput.contains("create_parking_lot")) {
				  String[] parkingLotInput = userInput.split(" ");
				  String parkingLotId = parkingLotInput[1];
				  int numFloors = Integer.parseInt(parkingLotInput[2]);
				  int numSlotsPerFloor = Integer.parseInt(parkingLotInput[3]);
				  System.out.print(facade.createParkingLot(parkingLotId, numFloors, numSlotsPerFloor));
			  }
			  
			  else if(userInput.contains("park_vehicle")) {
				  String[] parkingLotInput = userInput.split(" ");
				  VehicleType vehicleType = VehicleType.valueOf(parkingLotInput[1]);
				  String regNo = parkingLotInput[2];
				  String color = parkingLotInput[3];
				  System.out.print(facade.parkVehicle(vehicleType, regNo, color));
			  }
		}
	}
}
