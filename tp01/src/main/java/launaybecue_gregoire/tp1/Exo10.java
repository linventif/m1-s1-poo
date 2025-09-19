package launaybecue_gregoire.tp1;

public class Exo10 {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Exo10:");
        System.out.println(findGCD(48, 18)); // 6
        System.out.println(findGCD(56, 98)); // 14
        System.out.println(findGCD(101, 10)); // 1
    }
}
