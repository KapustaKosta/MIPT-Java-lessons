public class Pair<T extends Comparable<T>> {

  private T first;
  private T second;

  public Pair(T first, T second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public T getSecond() {
    return second;
  }

  public T min() {
    if (first.compareTo(second) < 0) {
      return first;
    } else {
      return second;
    }
  }

  public T max() {
    if (first.compareTo(second) > 0) {
      return first;
    } else {
      return second;
    }
  }

  public static <T extends Comparable<T>> Pair<T> minMax(T[] arr) {
    if (arr == null) {
      throw new NullPointerException("Array is null");
    }

    if (arr.length == 0) {
      return null;
    }

    T min = arr[0];
    T max = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if (arr[i].compareTo(min) < 0) {
        min = arr[i];
      }
      if (arr[i].compareTo(max) > 0) {
        max = arr[i];
      }
    }

    return new Pair<T>(min, max);
  }
}