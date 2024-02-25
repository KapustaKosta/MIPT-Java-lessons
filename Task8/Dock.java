package Task8;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class Dock {

  public AtomicBoolean busy;
  public static final int LOADING_SPEED = 10;
  public ResourceType resourceType;

  public Dock(ResourceType resourceType) {
    this.resourceType = resourceType;
    busy = new AtomicBoolean(false);
  }

  static class LoadResource implements Runnable {

    private final Ship ship;
    private final Dock dock;
    private final Semaphore semaphore;

    public LoadResource(Ship ship, Dock dock, Semaphore semaphore) {
      this.ship = ship;
      this.dock = dock;
      this.semaphore = semaphore;
    }

    @Override
    public void run() {
      try {
        semaphore.acquire();
        System.out.println("Ship with capacity " + ship.capacity + " and resource type "
            + ship.resourceType.toString() + " is in tunnel");
        while (dock.busy.get()) {
          wait();
        }
        while (ship.resourceCount < ship.capacity) {
          ship.resourceCount += Dock.LOADING_SPEED;
          Thread.sleep(1000);
        }
        System.out.println("Ship with capacity " + ship.capacity + " and resource type "
            + ship.resourceType.toString() + " is loaded");
        semaphore.release();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
