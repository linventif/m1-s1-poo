package launaybecue_gregoire.tp1;

public class Exo10 {
    public static int findGCD(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            return findGCD(a - b, b);
        } else {
            return findGCD(a, b - a);
        }
    }

    public static void main(String[] args) {
        System.out.println("Exo10:");
        System.out.println(findGCD(48, 18)); // 6
        System.out.println(findGCD(56, 98)); // 14
        System.out.println(findGCD(101, 10)); // 1
    }
}
