package TextAnalyzer;

public class SpamAnalyzer extends KeywordAnalyzer {

  public SpamAnalyzer(String[] spamWords) {
    this.prohibitedWords = spamWords;
  }
}
