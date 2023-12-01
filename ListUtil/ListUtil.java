package ListUtil;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtil {

  public static List<Integer> medianSort(List<Integer> list) {
    if (list == null || list.isEmpty() || list.size() == 1) {
      return list;
    }
    List<Integer> copy = new ArrayList<>(list);
    copy.sort(Integer::compare);
    final int median;
    if (copy.size() % 2 == 0) {
      int med1 = copy.get(copy.size() / 2 - 1);
      int med2 = copy.get(copy.size() / 2);
      median = (med1 + med2) / 2;
    } else {
      median = copy.get(copy.size() / 2);
    }
    copy.sort(
        (Integer num1, Integer num2) -> {
          int medianDist1 = Math.abs(num1 - median);
          int medianDist2 = Math.abs(num2 - median);
          int compResult = Integer.compare(medianDist1, medianDist2);
          if (compResult != 0) {
            return compResult;
          }
          return Integer.compare(num1, num2);
        });
    return copy;
  }

  public static List<Integer> rangeList(int from, int to) {
    return new AbstractList<>() {
      @Override
      public Integer get(int index) {
        if (index < 0 || index >= size()) {
          throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        return from + index;
      }

      @Override
      public int size() {
        return Math.max(0, to - from);
      }

      @Override
      public int indexOf(Object o) {
        if (o instanceof Integer) {
          int value = (int) o;
          if (value >= from && value < to) {
            return value - from;
          }
        }
        return -1;
      }

      @Override
      public int lastIndexOf(Object o) {
        if (o instanceof Integer) {
          int value = (int) o;
          if (value >= from && value < to) {
            return value - from;
          }
        }
        return -1;
      }

      @Override
      public boolean contains(Object o) {
        return indexOf(o) != -1;
      }
    };
  }
}
