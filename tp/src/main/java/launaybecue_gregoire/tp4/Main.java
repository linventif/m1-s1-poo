package launaybecue_gregoire.tp4;

public class Main {
  public static void main(String[] args) {
    // Test Tuple and Triple classes
    Tuple<String, Integer> tuple = new Tuple<>("Hello", 42);
    System.out.println("Tuple: " + tuple.getFirst() + ", " + tuple.getSecond());

    Triple<String, Integer, Double> triple = new Triple<>("Hello", 42, 3.14);
    System.out.println("Triple: " + triple.getFirst() + ", " + triple.getSecond() + ", " + triple.getThird());
  }
}
