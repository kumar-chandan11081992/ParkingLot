package interfaces;

import enums.VehicleType;
import models.Vehicle;

public interface ISlot {

	public VehicleType getSupportedVehicleType();

	public IVehicle getVehicle();
	
	public boolean isOccupied();
	public void setOccupied(boolean occupied);
	public IFloor getFloor();
	public String getSlotId();
	public void setSlotId(String id);
}
