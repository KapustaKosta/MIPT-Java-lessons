package Task9;

import Random.RandomNumsGenerator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Waiter {

  private Lock lock = new ReentrantLock();
  private String name;

  public Waiter(String name) {
    this.name = name;
  }

  public void deliver(Order order) {
    lock.lock();
    System.out.println("Waiter " + name + " is delivering order with ID: " + order.id);
    try {
      Thread.sleep(RandomNumsGenerator.generateRandom(2000, 6000));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Waiter " + name + " delivered order with ID: " + order.id);
    lock.unlock();
  }
}
