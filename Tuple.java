public class Tuple<T> {

  private T[] elements;
  private int size;

  public Tuple(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity cannot be negative");
    }
    this.elements = (T[]) new Object[capacity];
    this.size = 0;
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of range: " + index);
    }
    return (T) elements[index];
  }

  public void add(T el) {
    if (size >= elements.length) {
      throw new IllegalStateException("Tuple is full");
    }
    elements[size++] = el;
  }

  public void add(T el, int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index out of range: " + index);
    }
    if (size >= elements.length) {
      throw new IllegalStateException("Tuple is full");
    }

    T last = elements[index];
    for (int i = index + 1; i <= size; i++) {
      T temp = elements[i];
      elements[i] = last;
      last = temp;
    }

    elements[index] = el;
    size++;
  }

  public void remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of range: " + index);
    }
    T last = elements[size - 1];
    elements[size - 1] = null;
    for (int i = size - 2; i >= index; i--) {
      T temp = elements[i];
      elements[i] = last;
      last = temp;
    }

    elements[--size] = null;
  }

  public void remove(T el) {
    for (int i = 0; i < size; i++) {
      if (elements[i].equals(el)) {
        remove(i);
        return;
      }
    }
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public T orElse(int i, T defaultValue) {
    if (i < 0 || i >= size) {
      return defaultValue;
    }
    return (T) elements[i];
  }
}