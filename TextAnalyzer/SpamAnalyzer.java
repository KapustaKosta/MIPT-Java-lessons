package TextAnalyzer;

public class SpamAnalyzer extends KeywordAnalyzer {

  public SpamAnalyzer(String[] spamWords) {
    this.prohibitedWords = spamWords;
  }

  @Override
  public Label processText(String text) {
    for (String word :
        prohibitedWords) {
      if (text.contains(word)) {
        return Label.SPAM;
      }
    }
    return Label.OK;
  }
}
