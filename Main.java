import Matrix.Matrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import Matrix.GenericMatrix;

public class Main {

  public static void main(String[] args) {
    // Task 1
    GenericMatrix<String> matrix = new GenericMatrix<String>(3, 4);
    matrix.add("m", 1, 1);
    matrix.add("i", 1, 2);
    matrix.add("p", 1, 3);
    matrix.add("t", 1, 4);
    matrix.add("o", 2, 1);
    matrix.add("f", 2, 2);
    matrix.add("B", 2, 3);
    matrix.add("a", 2, 4);
    Matrix<String> matrix1 = new GenericMatrix<String>(matrix);
    assert matrix1.get(1, 1).equals("m") : "Метод работает некорректно";
    assert matrix1.get(1, 2).equals("i") : "Метод работает некорректно";
    assert matrix1.get(1, 4).equals("t") : "Метод работает некорректно";
    matrix1.remove(1, 3);
    assert matrix1.get(1, 3) == null : "Метод работает некорректно";

    // Task 2
    Tuple<Long> tuple = new Tuple<>(5);
    tuple.add(13L);
    tuple.add(31L);
    tuple.add(666L);
    tuple.add(3124L);
    tuple.add(1488L, 1);
    tuple.remove(2);
    tuple.add(999L, 4);
    assert tuple.get(0) == 13 : "Метод работает некорректно";
    assert tuple.get(1) == 1488 : "Метод работает некорректно";
    assert tuple.get(2) == 666 : "Метод работает некорректно";
    assert tuple.get(3) == 3124 : "Метод работает некорректно";

    // Task 3
    Pair<Character> pair = new Pair<>('F', 'A');
    assert pair.max().equals('F') : "Метод работает некорректно";

    // Task 4
    Pair<Integer> maxMinPair = Pair.minMax(new Integer[]{235, 13, 45, 36, 12});
    assert (maxMinPair.getSecond() == 235 &&
        maxMinPair.getFirst() == 12) : "Метод работает некорректно";

    // Task 5
    List<Integer> list = Arrays.asList(1, 2, 3, 42, 89);
    Function<Integer, String> function = (Integer num) ->
    {
      return "чиселка " + num;
    };
    List<String> result = map(list, function);
    assert result.get(0).equals("чиселка 1") : "Метод работает некорректно";
    assert result.get(1).equals("чиселка 2") : "Метод работает некорректно";
    assert result.get(2).equals("чиселка 3") : "Метод работает некорректно";
    assert result.get(3).equals("чиселка 42") : "Метод работает некорректно";
    assert result.get(4).equals("чиселка 89") : "Метод работает некорректно";
  }

  public static <T, R> List<R> map(List<? extends T> list,
      Function<? super T, ? extends R> function) {
    List<R> result = new ArrayList<>();
    for (T element : list) {
      result.add(function.apply(element));
    }
    return result;
  }
}