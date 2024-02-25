package Task8;

public interface ShipGenerator {

  Ship generate();

  boolean subscribe(OnGenerateShip onGenerateShip);
}
