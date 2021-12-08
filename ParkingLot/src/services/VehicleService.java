package services;

import enums.VehicleType;
import interfaces.IVehicle;
import interfaces.IVehicleService;
import models.Vehicle;

public class VehicleService implements IVehicleService{

	public IVehicle createVehicle(VehicleType type, String resitrationNumber, String color) {
		return new Vehicle(type, resitrationNumber, color);
	}
}
