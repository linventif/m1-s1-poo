package launaybecue_gregoire.tp4;

import java.util.HashMap;

public class Randomer {
  private static HashMap<Integer, Integer> map = new HashMap<>();
  private static int size = 100;
  private static int size_left = size;

  public static void main(String[] args) {
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
      System.out.println(key + " : " + map.get(key));
    }
  }
}