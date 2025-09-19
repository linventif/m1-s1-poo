package launaybecue_gregoire.tp1;

public class Exo12 {
    public static String generateRandomTable(int size, int min, int max) {
        int[] tbl = new int[size];

        for (int i = 0; i < size; i++) {
            tbl[i] = (int) (Math.random() * (max - min + 1)) + min;
        }

        return java.util.Arrays.toString(tbl);
    }

    public static void main(String[] args) {
        System.out.println("Exo12:");
        System.out.println(generateRandomTable(10, -100, 100));
    }
}
