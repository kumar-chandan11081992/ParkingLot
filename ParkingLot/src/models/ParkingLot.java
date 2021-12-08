package models;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import enums.VehicleType;
import interfaces.IFloor;
import interfaces.IParkingLot;
import interfaces.ISlot;

public class ParkingLot implements IParkingLot{

	String id;
	int floors;
	int slotsPerFloor;
	HashMap<VehicleType,HashMap<Integer,Integer>> numberOfSlotsLeft;
	
	ConcurrentHashMap<Integer, IFloor> parkingLotMap;

	static ParkingLot parkingLot;
	
	private ParkingLot(String id,int floors,int slotsPerFloor) {
		this.id = id;
		this.floors = floors;
		this.slotsPerFloor = slotsPerFloor;
		this.numberOfSlotsLeft = new HashMap<VehicleType, HashMap<Integer,Integer>>();
		this.parkingLotMap = new ConcurrentHashMap<Integer, IFloor>();
		populateNumberOfSlotsLeftMap();
	}
	
	public ConcurrentHashMap<Integer, IFloor> getParkingLotMap() {
		return parkingLotMap;
	}

	public void setParkingLotMap(ConcurrentHashMap<Integer, IFloor> parkingLotMap) {
		this.parkingLotMap = parkingLotMap;
	}
	
	public static ParkingLot getInstance(String id,int floors,int slotsPerFloor) {
		if(parkingLot == null) {
			parkingLot = new ParkingLot(id, floors, slotsPerFloor);
			ConcurrentHashMap<Integer, IFloor> floorMap = parkingLot.getParkingLotMap();
			for(int i = 1; i< floors; i++) {
				IFloor floor = new Floor(Integer.toString(i), slotsPerFloor);
				List<ISlot> slots = floor.getSlots();
				for(int j = 1; j< slotsPerFloor; j++) {
					if(j == 1) {
						ISlot slot = new Slot(VehicleType.TRUCK, floor, Integer.toString(j));
						slots.add(slot);	
					}
					else if(j == 2 || j == 3) {
						ISlot slot = new Slot(VehicleType.BIKE, floor, Integer.toString(j));
						slots.add(slot);	
					}
					else {
						ISlot slot = new Slot(VehicleType.CAR, floor, Integer.toString(j));
						slots.add(slot);	
					}
				}
				
				floorMap.put(i, floor);
			}
		}
		
		return parkingLot;
	}
	
	public static ParkingLot getInstance() {
		return parkingLot;
	}
	
	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public void setSlotsPerFloor(int slotsPerFloor) {
		this.slotsPerFloor = slotsPerFloor;
	}

	@Override
	public int getFloors() {
		return this.floors;
	}

	@Override
	public int getSlotsPerFloor() {
		return this.slotsPerFloor;
	}
	
	@Override 
	public HashMap<VehicleType,HashMap<Integer,Integer>> getNumberOfSlotsLeft(){
		return this.numberOfSlotsLeft;
	}
	
	private void populateNumberOfSlotsLeftMap() {
		HashMap<Integer, Integer> hmTruck = new HashMap<>();
		for(int i = 1; i < this.floors; i++) {
			hmTruck.put(i, 1);
		}
		
		HashMap<Integer, Integer> hmBike = new HashMap<>();
		for(int i = 1; i < this.floors; i++) {
			hmBike.put(i, 2);
		}
		
		HashMap<Integer, Integer> hmCar = new HashMap<>();
		for(int i = 1; i < this.floors; i++) {
			hmCar.put(i, this.slotsPerFloor - 3);
		}
		
		this.numberOfSlotsLeft.put(VehicleType.TRUCK, hmTruck);
		this.numberOfSlotsLeft.put(VehicleType.BIKE, hmBike);
		this.numberOfSlotsLeft.put(VehicleType.CAR, hmCar);
	}

}
