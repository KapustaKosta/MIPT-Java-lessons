import TextAnalyzer.TextAnalyzer;
import TextAnalyzer.SpamAnalyzer;
import TextAnalyzer.NegativeTextAnalyzer;
import java.util.function.IntFunction;

public class Main {

  public static void main(String[] args) {
    // Task 1
    IntSequence sequence = IntSequence.of(2, 32, 4, 1);
    System.out.println(sequence.next());
    System.out.println(sequence.next());

    // Task 2
    TextAnalyzer[] analyzers = new TextAnalyzer[2];
    analyzers[0] = new NegativeTextAnalyzer();
    analyzers[1] = new SpamAnalyzer(new String[]{"лох"});
    System.out.println(Test.checkLabels(analyzers, "Привет :|, лох"));

    // Task 3
    Printable printable = () -> System.out.println("Арбуз");
    Printable.execute(printable);

    // Task 4
    IntFunction<String> stringIntFunction = (int number) -> {
      if (number > 0) {
        return "Положительное число";
      } else if (number < 0) {
        return "Отрицательное число";
      } else {
        return "Ноль";
      }
    };
    System.out.println(stringIntFunction.apply(3));

    // Task 5
    try {
      int a = 90;
      int b = 3;
      System.out.println(a / b);
      printSum(23, 234);
      int[] abc = {1, 2};
      abc[3] = 9;
    } catch (IndexOutOfBoundsException ex) {
      System.out.println("Массив выходит за пределы своего размера!");
    } catch (Exception ex) {
      System.out.println("Что-то пошло не так...");
    }

    // Task 6
    try {
      int a = 42 / 0;
    } catch (ArithmeticException exception) {
      System.out.println(exception.getMessage());
    }

    // Task 7
    try {
      String s = null;
      String m = s.toLowerCase();
    } catch (NullPointerException exception) {
      System.out.println(exception.getMessage());
    }

    // Task 8
    try {
      int[] m = new int[2];
      m[8] = 5;
    } catch (IndexOutOfBoundsException exception) {
      System.out.println(exception.getMessage());
    }
  }

  public static void printSum(Integer a, Integer b) {
    System.out.println(a + b);
  }
}