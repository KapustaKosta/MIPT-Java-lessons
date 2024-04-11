package Task2;

public class YetAnotherThread extends Thread {
  private String name;
  private int count;

  public YetAnotherThread(String name, int count)
  {
    this.name = name;
    this.count = count;
  }

  @Override
  public void run()
  {
    for(int i = 0 ; i < count ; i++)
    {
        System.out.println(name);
    }
  }
}
