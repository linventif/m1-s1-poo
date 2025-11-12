package launaybecue_gregoire.tp5;

import java.util.HashMap;

public class Scable {
  //
  // blank tiles (scoring 0 points)
  // 1 point: E ×12, A ×9, I ×9, O ×8, N ×6, R ×6, T ×6, L ×4, S ×4, U ×4
  // 2 points: D ×4, G ×3
  // 3 points: B ×2, C ×2, M ×2, P ×2
  // 4 points: F ×2, H ×2, V ×2, W ×2, Y ×2
  // 5 points: K ×1
  // 8 points: J ×1, X ×1
  // 10 points: Q ×1, Z ×1

  private static HashMap<String, HashMap<Character, Integer>> dictionary = new HashMap<>();

  static {
    HashMap<Character, Integer> FRLetterPoint = new HashMap<>();
    FRLetterPoint.put('E', 1);
    FRLetterPoint.put('A', 1);
    FRLetterPoint.put('I', 1);
    FRLetterPoint.put('O', 1);
    FRLetterPoint.put('N', 1);
    FRLetterPoint.put('R', 1);
    FRLetterPoint.put('T', 1);
    FRLetterPoint.put('L', 1);
    FRLetterPoint.put('S', 1);
    FRLetterPoint.put('U', 1);
    FRLetterPoint.put('D', 2);
    FRLetterPoint.put('G', 2);
    FRLetterPoint.put('B', 3);
    FRLetterPoint.put('C', 3);
    FRLetterPoint.put('M', 3);
    FRLetterPoint.put('P', 3);
    FRLetterPoint.put('F', 4);
    FRLetterPoint.put('H', 4);
    FRLetterPoint.put('V', 4);
    FRLetterPoint.put('W', 4);
    FRLetterPoint.put('Y', 4);
    FRLetterPoint.put('K', 5);
    FRLetterPoint.put('J', 8);
    FRLetterPoint.put('X', 8);
    FRLetterPoint.put('Q', 10);
    FRLetterPoint.put('Z', 10);
    dictionary.put("FR", FRLetterPoint);
  }

  private static int calculPoint(String word, String language) {
    int score = 0;
    HashMap<Character, Integer> letterPoints = dictionary.get(language);
    for (char c : word.toUpperCase().toCharArray()) {
      score += letterPoints.getOrDefault(c, 0);
    }
    return score;
  }

  public static void main(String[] args) {
    String testWord = "Bonjour";
    String testLang = "FR";
    System.out.println("Le mot " + testWord + " vaut " + calculPoint(testWord, testLang) + " points en français.");
  }
}
