package launaybecue_gregoire.tp4;

import java.util.HashMap;

public class RandomerExo3 {
  private HashMap<Integer, Integer> map = new HashMap<>();
  private int size;
  private int size_left;

  public RandomerExo3(int newSize) {
    size = newSize;
    size_left = newSize;
    map.clear();
  }

  public void Run() {
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
  }
}