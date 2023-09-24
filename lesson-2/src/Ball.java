public final class Ball extends Shape {
  private double radius;

  public Ball(double radius)
  {
    super(calculateVolume(radius));
    this.radius = radius;
  }

  private static double calculateVolume(double radius)
  {
    return (double) 4/3 * Math.PI * Math.pow(radius, 3);
  }


  @Override
  public void print()
  {
    String toPrint = String.format("Ball radius: %f\nvolume: %f", radius, volume);
    System.out.println(toPrint);
  }
}
