package Task8;

import Random.RandomNumsGenerator;

public class SimpleShipGenerator implements ShipGenerator {

  private OnGenerateShip onGenerateShip;

  @Override
  public Ship generate() {
    int capType = RandomNumsGenerator.generateRandom(1, 3);
    int resType = RandomNumsGenerator.generateRandom(1, 3);
    int capacity = 0;
    ResourceType resourceType = null;
    switch (capType) {
      case 1: {
        capacity = 10;
        break;
      }
      case 2: {
        capacity = 50;
        break;
      }
      case 3: {
        capacity = 100;
        break;
      }
    }
    switch (resType) {
      case 1: {
        resourceType = new Bread();
        break;
      }
      case 2: {
        resourceType = new Bananas();
        break;
      }
      case 3: {
        resourceType = new Clothes();
        break;
      }
    }
    Ship ship = new Ship(capacity, resourceType);
    onGenerateShip.useShip(ship);
    return ship;
  }

  @Override
  public boolean subscribe(OnGenerateShip onGenerateShip) {
    this.onGenerateShip = onGenerateShip;
    return true;
  }
}


