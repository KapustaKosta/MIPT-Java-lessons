package Task3;

import static Random.RandomNumsGenerator.generateRandom;

public class NumbersFillerPrinter {
  private final int[] numbers;
  private boolean filled;

  public NumbersFillerPrinter(int numbersCount) {
    numbers = new int[numbersCount];
    filled = false;
  }

  public synchronized void fill() {
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = generateRandom(1, 100);
    }
    filled = true;
    notify();
  }

  public synchronized void print() {
    while (!filled) {
      try {
        wait();
      } catch (InterruptedException exception) {
        exception.printStackTrace();
      }
    }

    for (int number : numbers) {
      System.out.print(number + " ");
    }
    System.out.println();
  }
}
