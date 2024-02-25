package Task4;

import java.util.concurrent.locks.ReentrantLock;

public class NumbersPrinter {

  private ReentrantLock lock;
  int iterValue;

  public NumbersPrinter() {
    lock = new ReentrantLock();
    iterValue = 1;
  }

  public void print() {
    EvenNumbersPrinter evenNumbersPrinter = new EvenNumbersPrinter();
    OddNumbersPrinter oddNumbersPrinter = new OddNumbersPrinter();
    Thread evenThread = new Thread(evenNumbersPrinter::print);
    Thread oddThread = new Thread(oddNumbersPrinter::print);
    evenThread.start();
    oddThread.start();
    try {
      evenThread.join();
      oddThread.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  class EvenNumbersPrinter {

    public void print() {
      while (iterValue < 10) {
        lock.lock();
        if (iterValue % 2 == 0) {
          System.out.println(iterValue);
          iterValue++;
        }
        lock.unlock();
      }
    }
  }

  class OddNumbersPrinter {

    public void print() {
      while (iterValue < 10) {
        lock.lock();
        if (iterValue % 2 != 0) {
          System.out.println(iterValue);
          iterValue++;
        }
        lock.unlock();
      }
    }
  }
}
