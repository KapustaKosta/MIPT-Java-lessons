package shape;

public non-sealed class Pyramid extends Shape {

  private double height;
  private double area; // площадь основания

  public Pyramid(double height, double area) {
    super(calculateVolume(height, area));
    this.height = height;
    this.area = area;
  }

  private static double calculateVolume(double height, double area) {
    return (double) 1 / 3 * area * height;
  }

  @Override
  public void print() {
    String toPrint = String.format("shape.Pyramid height: %f\narea: %f\nvolume: %f", height, area,
        volume);
    System.out.println(toPrint);
  }
}

