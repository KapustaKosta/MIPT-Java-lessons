package Task6;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class Chest {
  public AtomicInteger gold;

  public Chest()
  {
    gold = new AtomicInteger(0);
  }

  public static class IncreaseGoldTask implements Callable<Integer> {

    private final int gold;
    private final Chest chest;

    public IncreaseGoldTask(int gold, Chest chest) {
      this.gold = gold;
      this.chest = chest;
    }

    @Override
    public Integer call() {
      int goldInChest = chest.gold.addAndGet(gold);
      System.out.println("Gold in chest now: " + goldInChest);
      return goldInChest;
    }
  }
}
