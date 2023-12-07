package Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

  public static void main(String[] args) {
  }

  public static List<Integer> findPrimes(int n) {
    List<Integer> primes = new ArrayList<>();
    HashSet<Integer> numbers = new HashSet<>();
    for (int i = 2; i <= n; i++) {
      numbers.add(i);
    }
    while (!numbers.isEmpty()) {
      int prime = Collections.min(numbers);
      primes.add(prime);
      for (int i = prime; i <= n; i += prime) {
        numbers.remove(i);
      }
    }
    return primes;
  }
}