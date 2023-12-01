package DoubleIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleIterator<T> implements Iterator<T> {

  private final Iterator<T> firstIterator;
  private final Iterator<T> secondIterator;
  private boolean isFirstIterator;

  public DoubleIterator(Iterator<T> firstIterator, Iterator<T> secondIterator) {
    this.firstIterator = firstIterator;
    this.secondIterator = secondIterator;
    this.isFirstIterator = true;
  }

  @Override
  public boolean hasNext() {
    return isFirstIterator ? firstIterator.hasNext() : secondIterator.hasNext();
  }

  @Override
  public T next() {
    if (isFirstIterator && firstIterator.hasNext()) {
      return firstIterator.next();
    } else if (secondIterator.hasNext()) {
      isFirstIterator = false;
      return secondIterator.next();
    } else {
      throw new NoSuchElementException();
    }
  }
}