package interfaces;

import java.util.List;

public interface IFloor {
 public List<ISlot> getSlots();
 public void setSlots(List<ISlot> slots);
 public String getFloorId();
}
