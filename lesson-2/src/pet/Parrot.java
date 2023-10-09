package pet;

public class Parrot extends Pet{

  public Country country;

  private boolean hasDocuments = false;
  @Override
  public void say() {
    System.out.println("squawk");
  }

  public void Fly()
  {
    int min = 1;
    int max = 60;
    int minutes = min + (int)(Math.random() * ((max - min) + 1));

    System.out.println("A parrot " + name + " flew away, but "
        + "promised to return after " + minutes + " minutes");
  }
}