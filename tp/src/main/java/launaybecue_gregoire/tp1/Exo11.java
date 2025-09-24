package launaybecue_gregoire.tp1;

public class Exo11 {
    public static int[] generateRandomTable(int size, int min, int max) {
        int[] tbl = new int[size];

        for (int i = 0; i < size; i++) {
            tbl[i] = (int) (Math.random() * (max - min + 1)) + min;
        }

        return tbl;
    }

    public static void main(String[] args) {
        System.out.println("Exo11:");
        int[] randomTable = generateRandomTable(10, 1, 100);
        System.out.println(java.util.Arrays.toString(randomTable));
    }
}
