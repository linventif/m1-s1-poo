package launaybecue_gregoire.tp1;

public class Exo04 {
    public static int sumOfMultiplesOf7(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Exo04:");
        System.out.println(sumOfMultiplesOf7(1, 20)); // 49 (7 + 14)
        System.out.println(sumOfMultiplesOf7(1, 7)); // 7
        System.out.println(sumOfMultiplesOf7(8, 13)); // 0
    }
}
