package shape;

final public class ColourPyramid extends Pyramid {

  private String colour;

  public ColourPyramid(double height, double area, String colour) {
    super(height, area);
    this.colour = colour;
  }

  @Override
  public void print() {
    super.print();
    String toPrint = String.format("colour: %s", colour);
    System.out.println(toPrint);
  }
}
