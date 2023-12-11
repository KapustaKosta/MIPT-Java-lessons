package WordSplitterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class WordSpliterator implements Spliterator<String> {

  private final String text;
  private int currentPos;

  public WordSpliterator(String text) {
    this.text = text;
  }

  @Override
  public boolean tryAdvance(Consumer<? super String> action) {
    int nextPos = text.indexOf(' ', currentPos);
    if (nextPos == -1) {
      if (currentPos < text.length()) {
        action.accept(text.substring(currentPos));
        currentPos = text.length();
        return true;
      } else {
        return false;
      }
    } else {
      action.accept(text.substring(currentPos, nextPos));
      currentPos = nextPos + 1;
      return true;
    }
  }

  @Override
  public Spliterator<String> trySplit() {
    int mid = (currentPos + text.length()) / 2;
    int nextPos = text.lastIndexOf(' ', mid);
    if (nextPos == -1 || nextPos == currentPos) {
      return null;
    }
    WordSpliterator newSpliterator = new WordSpliterator(text.substring(nextPos + 1));
    currentPos = nextPos + 1;
    return newSpliterator;
  }

  @Override
  public long estimateSize() {
    return text.length() - currentPos;
  }

  @Override
  public int characteristics() {
    return ORDERED | SIZED;
  }
}