public final class Point {

  private final double x;
  private final double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Point() {
    this(0, 0);
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public Point translate(double deltaX, double deltaY) {
    return new Point(this.x + deltaX, this.y + deltaY);
  }

  public Point scale(double deltaX) {
    return new Point(this.x * deltaX, this.y * deltaX);
  }
}