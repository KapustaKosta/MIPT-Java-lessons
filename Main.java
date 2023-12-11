import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

  public static void main(String[] args) {
    Function<Object, String> sayHello = saySmth("Hello");
    System.out.println(sayHello.apply("Alice")); // Выведет "Hello, Alice!"
  }

  public static <T, R> Optional<R> processElements(List<T> elements, Predicate<T> predicate,
      Function<T, R> mapper, BinaryOperator<R> operator) {
    return elements
        .stream()
        .filter(predicate)
        .map(mapper)
        .reduce(operator);
  }

  static Function<Integer, Integer> multiplyByTwo = bind((a, b) -> a * b, 2);

  static Function<String, String> getSubstring = bind((a, b) -> b.substring(0, a), 5);

  static <A, B, C> Function<B, C> bind(BiFunction<A, B, C> fn, A a) {
    return b -> fn.apply(a, b);
  }

  static Function<Object, String> saySmth(String greeting) {
    return curry((g, n) -> String.format("%s, %s!", g, n)).apply(greeting);
  }

  static <A, B, C> Function<A, Function<B, C>> curry(BiFunction<A, B, C> fn) {
    return a -> b -> fn.apply(a, b);
  }
}