package shape;

public sealed class Shape permits Ball, Cylinder, Pyramid {

  protected double volume;

  public Shape(double volume) {
    this.volume = volume;
  }

  public void print() {
    System.out.println("shape.Shape volume: " + volume);
    System.out.println();
  }
}