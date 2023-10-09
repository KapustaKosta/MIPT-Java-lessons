package shape;

import shape.Shape;

public final class Cylinder extends Shape {
  private double height;
  private double radius;

  public Cylinder(double height, double radius) {
    super(calculateVolume(height, radius));
    this.height = height;
    this.radius = radius;
  }

  private static double calculateVolume(double height, double radius)
  {
    return Math.PI * Math.pow(radius, 2) * height;
  }

  @Override
  public void print()
  {
    String toPrint = String.format("shape.Cylinder height: %f\nradius: %f\nvolume: %f", height, radius, volume);
    System.out.println(toPrint);
  }
}
