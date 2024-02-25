package Task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class NumbersFileReader {

  public static int[] read() {
    try {
      String filePath = "src/resources/data.txt";
      String line = Files.readString(Paths.get(filePath));

      String[] numbersString = line.trim().split(" ");
      int[] result = Arrays.stream(numbersString)
          .mapToInt(Integer::parseInt)
          .toArray();

      return result;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
