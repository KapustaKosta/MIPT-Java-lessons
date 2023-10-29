public interface Printable {
  void print();

  static void execute(Printable printable) {
    printable.print();
  }
}