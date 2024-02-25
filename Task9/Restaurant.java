package Task9;

import Random.RandomNumsGenerator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {

  private final int ThreadPoolCount = 5;
  private final ExecutorService executorService = Executors.newFixedThreadPool(ThreadPoolCount);
  private final ConcurrentLinkedQueue<Order> orders = new ConcurrentLinkedQueue<>();
  private final Chief[] chiefs;
  private final Waiter[] waiters;

  public Restaurant(Chief[] chiefs, Waiter[] waiters) {
    this.chiefs = chiefs;
    this.waiters = waiters;
  }

  public void addOrder(Order order) {
    orders.add(order);
    processOrder(order);
  }

  public void processOrder(Order order) {
    Chief randomChief = getRandomChief();
    Waiter randomWaiter = getRandomWaiter();
    CompletableFuture<Order> chiefFuture = CompletableFuture.supplyAsync(
        () -> randomChief.cook(order), executorService);
    chiefFuture.thenComposeAsync(
        processedOrder -> CompletableFuture.runAsync(() -> randomWaiter.deliver(processedOrder),
            executorService));
  }

  public Chief getRandomChief() {
    if (chiefs.length == 0) {
      return null;
    }
    int randomChiefNum = RandomNumsGenerator.generateRandom(0, chiefs.length - 1);
    return chiefs[randomChiefNum];
  }

  public Waiter getRandomWaiter() {
    if (waiters.length == 0) {
      return null;
    }
    int randomWaiterNum = RandomNumsGenerator.generateRandom(0, waiters.length - 1);
    return waiters[randomWaiterNum];
  }
}
