package Set;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {

  public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = new HashSet<>(s1);
    result.addAll(s2);
    return result;
  }

  public static <E> Set<E> intersection(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = new HashSet<>(s1);
    result.retainAll(s2);
    return result;
  }

  public static <E> Set<E> difference(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = new HashSet<>(s1);
    result.removeAll(s2);
    return result;
  }

  public static <E> Set<E> symmetricDifference(Set<? extends E> s1, Set<? extends E> s2) {
    Set<E> result = new HashSet<>();
    Set<E> unionSet = union(s1, s2);
    result.addAll(unionSet);
    Set<E> intersectionSet = intersection(s1, s2);
    result.removeAll(intersectionSet);
    return result;
  }
}
