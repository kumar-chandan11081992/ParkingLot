package interfaces;

import enums.VehicleType;

public interface IParkingLotService {
	public IParkingLot createParkingLot(String parkingLotId, int noOfFloors, int noOFSlotsPerFloor);
	public ITicket parkVehicle(VehicleType vehicleType, String regNo, String color);
}
