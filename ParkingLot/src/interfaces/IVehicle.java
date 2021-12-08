package interfaces;

import enums.VehicleType;

public interface IVehicle {
	public VehicleType getType();

	public String getResitrationNumber();


	public String getColor();

	public ISlot getSlot(); 
	public void setSlot(ISlot slot);
}
