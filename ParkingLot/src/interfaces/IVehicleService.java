package interfaces;

import enums.VehicleType;

public interface IVehicleService {
	public IVehicle createVehicle(VehicleType type, String resitrationNumber, String color);
}
