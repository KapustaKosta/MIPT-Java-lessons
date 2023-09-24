public non-sealed class Pyramid extends Shape{
  private double height;
  private double area; // площадь основания

  public Pyramid(double height, double area) {
    super(calculateVolume(height, area));
    this.height = height;
    this.area = area;
  }

  private static double calculateVolume(double height, double area)
  {
    return (double) 1/3 * area * height;
  }

  @Override
  public void print()
  {
    String toPrint = String.format("Pyramid height: %f\narea: %f\nvolume: %f", height, area, volume);
    System.out.println(toPrint);
  }
}

final class ColourPyramid extends Pyramid{
  private String colour;

  public ColourPyramid(double height, double area, String colour) {
    super(height, area);
    this.colour = colour;
  }

  @Override
  public void print()
  {
    super.print();
    String toPrint = String.format("colour: %s", colour);
    System.out.println(toPrint);
  }
}