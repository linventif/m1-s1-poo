
package launaybecue_gregoire.tp5;

import java.util.ArrayList;

public class RandomerExo4 {
  private ArrayList<Integer> ary = new ArrayList<Integer>();
  private int size;
  private int size_left;

  RandomerExo4(int newSize) {
    size = newSize;
    size_left = newSize;
    ary.clear();
    for (int i = 0; i < size; i++) {
      ary.add(null);
    }
  }

  public void Run() {
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
  }
}