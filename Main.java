import static Random.RandomNumsGenerator.generateRandom;

import Task1.NumbersFileReader;
import Task2.YetAnotherThread;
import Task3.NumbersFillerPrinter;
import Task4.NumbersPrinter;
import Task6.Chest;
import Task8.ShipManager;
import Task8.SimpleShipGenerator;
import Task9.Chief;
import Task9.Order;
import Task9.Restaurant;
import Task9.Waiter;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

  private static final int numbersCount = 10;
  private static final int[] numbers = new int[numbersCount];

  public static void main(String[] args) {
    // 1
    long startTime = System.currentTimeMillis();
    int[] numbers = NumbersFileReader.read();
    Pair maxMin = findMaxMin(numbers);
    System.out.println(maxMin.max + " " + maxMin.min);
    long estimatedTime = System.currentTimeMillis() - startTime;
    System.out.println("1 thread: " + estimatedTime);

    startTime = System.currentTimeMillis();
    Thread maxThread = new Thread(() ->
    {
      int[] numbersThread = NumbersFileReader.read();
      long max = Arrays.stream(numbersThread).asLongStream().max().getAsLong();
      System.out.println(max);
    });

    Thread minThread = new Thread(() ->
    {
      int[] numbersThread = NumbersFileReader.read();
      long min = Arrays.stream(numbersThread).asLongStream().min().getAsLong();
      System.out.println(min);
    });

    maxThread.start();
    minThread.start();
    try {
      maxThread.join();
      minThread.join();
      estimatedTime = System.currentTimeMillis() - startTime;
      System.out.println("2 threads: " + estimatedTime);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // 2
    final int threadsCount = 10;
    Thread[] threads = new Thread[threadsCount];
    for (int i = 0; i < threadsCount; i++) {
      threads[i] = new YetAnotherThread("id&" + i, generateRandom(1, 10));
    }
    for (Thread thread : threads) {
      thread.start();
    }

    // 3
    NumbersFillerPrinter fillerPrinter = new NumbersFillerPrinter(15);
    Thread fillThread = new Thread(fillerPrinter::fill);
    Thread printThread = new Thread(fillerPrinter::print);
    fillThread.start();
    printThread.start();
    try {
      fillThread.join();
      printThread.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    // 4
    NumbersPrinter numbersPrinter = new NumbersPrinter();
    numbersPrinter.print();

    // 6
    ExecutorService executor = Executors.newFixedThreadPool(3);
    Chest chest = new Chest();
    for (int i = 0; i < 10; i++) {
      int gold = generateRandom(1, 20);
      Chest.IncreaseGoldTask increaseGoldTask = new Chest.IncreaseGoldTask(gold, chest);
      executor.submit(increaseGoldTask);
      System.out.println("Gold added: " + gold);
    }

    // 8
    ShipManager shipManager = new ShipManager();
    SimpleShipGenerator shipGenerator = new SimpleShipGenerator();
    shipManager.subscribeGenerator(shipGenerator);
    for (int i = 0; i < 15; i++) {
      shipGenerator.generate();
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    // 9
    Chief[] chiefs = new Chief[]{
        new Chief("Dzhamshud"),
        new Chief("Rashid"),
        new Chief("Berzod")
    };
    Waiter[] waiters = new Waiter[]{
        new Waiter("Abdula"),
        new Waiter("Farhad")
    };
    Restaurant restaurant = new Restaurant(chiefs, waiters);
    restaurant.addOrder(new Order(931, new String[]{"Potato chips", "Americano"}));
    restaurant.addOrder(new Order(234, new String[]{"Black shaurma", "Pancakes"}));
    restaurant.addOrder(new Order(615, new String[]{"Hot dog", "Cheese shaurma"}));
    restaurant.addOrder(new Order(15, new String[]{"Potato chips", "Americano"}));
    restaurant.addOrder(new Order(763, new String[]{"Black shaurma", "Pancakes"}));
    restaurant.addOrder(new Order(135, new String[]{"Hot dog", "Cheese shaurma"}));
  }

  private static Pair findMaxMin(int[] nums) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num < min) {
        min = num;
      }
      if (num > max) {
        max = num;
      }
    }
    Pair res = new Pair(max, min);
    return res;
  }

  record Pair(int max, int min) {

  }
}