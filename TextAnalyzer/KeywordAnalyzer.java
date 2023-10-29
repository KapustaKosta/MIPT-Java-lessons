package TextAnalyzer;

public abstract class KeywordAnalyzer implements TextAnalyzer {

  protected String[] prohibitedWords;

  @Override
  public Label processText(String text) {
    for (String word :
        prohibitedWords) {
      if (text.contains(word)) {
        if (this instanceof SpamAnalyzer) {
          return Label.SPAM;
        } else if (this instanceof KeywordAnalyzer) {
          return Label.NEGATIVE_CONTENT;
        }
      }
    }
    return Label.OK;
  }
}
