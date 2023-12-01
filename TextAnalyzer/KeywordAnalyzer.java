package TextAnalyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer {

  protected String[] prohibitedWords;

  @Override
  public Label processText(String text) {
    for (String word :
        prohibitedWords) {
      if (text.contains(word)) {
        return Label.NEGATIVE_CONTENT;
      }
    }
    return Label.OK;
  }
}
