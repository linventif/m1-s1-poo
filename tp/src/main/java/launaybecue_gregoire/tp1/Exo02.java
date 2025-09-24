package launaybecue_gregoire.tp1;

public class Exo02 {
    public static int isBiggestReel(int nb1, int nb2, int nb3) {
        return Math.max(nb1, Math.max(nb2, nb3));
    }

    public static void main(String[] args) {
        System.out.println("Exo02:");
        System.out.println(isBiggestReel(10, 2, 3)); // 10
        System.out.println(isBiggestReel(2, 10, 3)); //
    }

}
