package launaybecue_gregoire.tp4;

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

  private static HashMap<Character, Integer> letterPoints = new HashMap<>();
  static {
    letterPoints.put('E', 1);
    letterPoints.put('A', 1);
    letterPoints.put('I', 1);
    letterPoints.put('O', 1);
    letterPoints.put('N', 1);
    letterPoints.put('R', 1);
    letterPoints.put('T', 1);
    letterPoints.put('L', 1);
    letterPoints.put('S', 1);
    letterPoints.put('U', 1);
    letterPoints.put('D', 2);
    letterPoints.put('G', 2);
    letterPoints.put('B', 3);
    letterPoints.put('C', 3);
    letterPoints.put('M', 3);
    letterPoints.put('P', 3);
    letterPoints.put('F', 4);
    letterPoints.put('H', 4);
    letterPoints.put('V', 4);
    letterPoints.put('W', 4);
    letterPoints.put('Y', 4);
    letterPoints.put('K', 5);
    letterPoints.put('J', 8);
    letterPoints.put('X', 8);
    letterPoints.put('Q', 10);
    letterPoints.put('Z', 10);
  }

  private static int calculPoint(String word) {
    int score = 0;
    for (char c : word.toUpperCase().toCharArray()) {
      score += letterPoints.getOrDefault(c, 0);
    }
    return score;
  }

  public static void main(String[] args) {
    String test = "zebra";
    System.out.println("Le mot " + test + " vaut " + calculPoint(test) + " points.");
  }
}
