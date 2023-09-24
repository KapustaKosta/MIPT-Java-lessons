public class Car {
  private final String model;
  private final String color;
  private int fuel;
  private final int maxFuel;
  private final Engine engine;
  private int mileage;

  public Car(String model, String color, int fuel, int maxFuel, int fuelConsumption) {
    this.model = model;
    this.color = color;
    this.fuel = fuel;
    this.maxFuel = maxFuel;
    this.engine = new Engine(fuelConsumption);
    mileage = 0;
  }

  public Car(Bulder bulder)
  {
    this.model = bulder.model;
    this.color = bulder.color;
    this.fuel = bulder.fuel;
    this.maxFuel = bulder.maxFuel;
    this.engine = bulder.engine;
    this.mileage = bulder.mileage;
  }

  public void refuel() {
    fuel = maxFuel;
  }

  public void refuel(int amount) {
    fuel = Math.min(maxFuel, fuel + amount);
  }

  public void startEngine() {
    if (fuel > 0) {
      engine.turnOn();
      System.out.println("Engine started");
    } else {
      System.out.println("Out of fuel, please refuel");
    }
  }

  public void stopEngine() {
    engine.turnOff();
    System.out.println("Engine stopped");
  }

  public void drive() {
    if (engine.working()) {
      double fuelConsumption = engine.getFuelConsumption();
      while(fuel - fuelConsumption >= 0)
      {
        fuel -= fuelConsumption;
        mileage += Engine.MILEAGE_IN_FUEL_CONSUMPTION;
      }
    } else {
      System.out.println("Engine is off, please start the engine");
    }
  }

  public void info()
  {
    String output = String.format("Car model %s info:\n"
        + "color: %s\nfuel: %d\n"
        + "maxFuel: %d\nmileage: %d\n"
        + "Fuel consumption: %d per %d miles\nengine working: %b", model, color,
        fuel, maxFuel, mileage,
        engine.fuelConsumption, Engine.MILEAGE_IN_FUEL_CONSUMPTION, engine.working);

    System.out.println(output);
  }

  private static class Engine {
    private final int fuelConsumption;

    public static final int MILEAGE_IN_FUEL_CONSUMPTION = 100;

    private boolean working = false;

    public Engine(int fuelConsumption) {
      this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption() {
      return this.fuelConsumption;
    }

    public void turnOn()
    {
      this.working = true;
    }

    public void turnOff()
    {
      this.working = false;
    }

    public boolean working()
    {
      return this.working;
    }
  }

  public static class Bulder
  {
    //required
    private int maxFuel;
    private Engine engine;

    //optional
    private String color;
    private String model;
    private int fuel;
    private int mileage;

    public Bulder(int maxFuel, int fuelConsumption)
    {
      this.maxFuel = maxFuel;
      this.engine = new Engine(fuelConsumption);
    }

    public Bulder setColor(String color)
    {
      this.color = color;
      return this;
    }

    public Bulder setModel(String model)
    {
      this.model = model;
      return this;
    }

    public Bulder setFuel(int fuel)
    {
      this.fuel = fuel;
      return this;
    }

    public Bulder setMileage(int mileage)
    {
      this.mileage = mileage;
      return this;
    }

    public Car build()
    {
      return new Car(this);
    }
  }
}
