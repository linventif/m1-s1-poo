package launaybecue_gregoire.tp4;

import java.util.ArrayList;
import java.util.HashMap;

public class Randomer {
  // Exo 1
  private static HashMap<Integer, Integer> map = new HashMap<>();
  private static int size = 100;
  private static int size_left = size;

  public static void exo1(String[] args) {
    System.out.println("Exo 1");
    while (size_left != 0) {
      int rd = (int) (Math.random() * size);
      Integer pos = map.get(rd);
      if (pos == null) {
        size_left--;
        map.put(rd, 1);
      } else {
        map.put(rd, pos + 1);
      }
    }

    for (Integer key : map.keySet()) {
      System.out.print(key + ":" + map.get(key) + ", ");
    }
  }

  // Exo 2
  private static ArrayList<Integer> ary = new ArrayList<Integer>();

  static {
    for (int i = 0; i < size; i++) {
      ary.add(null);
    }
  }

  public static void exo2(String[] args) {
    System.out.println("\nExo 2" + ary.size() + " " + size_left);

    while (size_left != 0) {
      int rd = (int) (Math.random() * size);
      Integer pos = ary.get(rd);
      if (pos == null) {
        size_left--;
        ary.set(rd, 1);
      } else {
        ary.set(rd, pos + 1);
      }
    }

    for (int i = 0; i < ary.size(); i++) {
      System.out.print(i + ":" + ary.get(i) + ", ");
    }
  }

  // Runner
  public static void main(String[] args) {
    size = 100;
    size_left = size;
    exo1(args);
    size = 100;
    size_left = size;
    exo2(args);
  }
}