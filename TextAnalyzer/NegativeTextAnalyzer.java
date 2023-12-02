package TextAnalyzer;

public class NegativeTextAnalyzer extends KeywordAnalyzer {

  public NegativeTextAnalyzer() {
    prohibitedWords = new String[]{":(", "=(", ":|"};
  }
}
