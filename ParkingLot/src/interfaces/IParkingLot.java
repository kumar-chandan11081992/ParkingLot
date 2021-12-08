package interfaces;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import enums.VehicleType;

public interface IParkingLot {
	public String getId();
	public int getFloors();
	public int getSlotsPerFloor();
	public HashMap<VehicleType,HashMap<Integer,Integer>> getNumberOfSlotsLeft();
	public ConcurrentHashMap<Integer, IFloor> getParkingLotMap();
}
