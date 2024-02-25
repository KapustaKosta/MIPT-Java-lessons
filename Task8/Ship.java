package Task8;

public class Ship {
  public final int capacity;
  public int resourceCount;
  public ResourceType resourceType;

  public Ship(int capacity, ResourceType resourceType) {
    this.capacity = capacity;
    this.resourceType = resourceType;
    this.resourceCount = 0;
  }
}
