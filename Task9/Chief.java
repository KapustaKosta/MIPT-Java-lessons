package Task9;

import Random.RandomNumsGenerator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chief {

  private Lock lock = new ReentrantLock();
  private String name;

  public Chief(String name) {
    this.name = name;
  }

  public Order cook(Order order) {
    lock.lock();
    System.out.println("Chief " + name + " is cooking order with ID: " + order.id);
    try {
      Thread.sleep(RandomNumsGenerator.generateRandom(5000, 10000));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Chief " + name + " cooked order with ID: " + order.id);
    lock.unlock();
    return order;
  }
}
