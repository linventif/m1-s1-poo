package launaybecue_gregoire.tp4;

public class RandomerExo5 {
  private static int size = 1000000;

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    long end = System.currentTimeMillis();
    RandomerExo3 exo3 = new RandomerExo3(size);
    RandomerExo4 exo4 = new RandomerExo4(size);

    start = System.currentTimeMillis();
    exo3.Run();
    end = System.currentTimeMillis();
    System.out.println("Exo 3 (HashMap) temps écoulé: " + (end - start) + " ms");

    start = System.currentTimeMillis();
    exo4.Run();
    end = System.currentTimeMillis();
    System.out.println("Exo 4 (ArrayList) temps écoulé: " + (end - start) + " ms");
  }
}
