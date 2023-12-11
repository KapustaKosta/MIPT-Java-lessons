package WordSplitterator;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Test {

  public static void main(String[] args) {
    String text = "This is a sample sentence demonstrating custom Spliterator implementation";
    Stream<String> wordStream = StreamSupport.stream(new WordSpliterator(text), false);
    wordStream.forEach(System.out::println);
  }
}