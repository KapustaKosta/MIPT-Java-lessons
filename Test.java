import TextAnalyzer.Label;
import TextAnalyzer.TextAnalyzer;

public class Test {

  public static Label checkLabels(TextAnalyzer[] textAnalyzers, String comment) {
    for (TextAnalyzer analyzer :
        textAnalyzers) {
      Label analyzeResult = analyzer.processText(comment);
      if (analyzeResult != Label.OK) {
        return analyzeResult;
      }
    }
    return Label.OK;
  }
}
