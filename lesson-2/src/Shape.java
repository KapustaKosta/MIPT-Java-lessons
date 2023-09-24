sealed public class Shape permits Ball, Cylinder, Pyramid {
  protected double volume;

  public Shape(double volume)
  {
    this.volume = volume;
  }

  public void print() {
    System.out.println("Shape volume: " + volume);
    System.out.println();
  }
}