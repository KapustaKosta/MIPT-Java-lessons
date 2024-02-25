package Task8;

import Task8.Dock.LoadResource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ShipManager implements OnGenerateShip {

  private final int tunnelCapacity = 5;
  ExecutorService executor = Executors.newFixedThreadPool(tunnelCapacity);
  private final Semaphore tunnelSemaphore = new Semaphore(5);
  private final Dock breadDock;
  private final Dock bananaDock;
  private final Dock clothesDock;

  public ShipManager() {
    breadDock = new Dock(new Bread());
    bananaDock = new Dock(new Bananas());
    clothesDock = new Dock(new Clothes());
  }

  public void subscribeGenerator(ShipGenerator generator) {
    generator.subscribe(this);
  }

  @Override
  public void useShip(Ship ship) {
    Dock dock;
    switch (ship.resourceType) {
      case Bread bread -> dock = breadDock;
      case Bananas bananas -> dock = bananaDock;
      case Clothes clothes -> dock = clothesDock;
      default -> dock = null;
    }
    Dock.LoadResource loadResource = new LoadResource(ship, dock, tunnelSemaphore);
    executor.submit(loadResource);
  }
}
