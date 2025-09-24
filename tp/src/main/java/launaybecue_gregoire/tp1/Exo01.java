package launaybecue_gregoire.tp1;

public class Exo01 {
    public static boolean estDiviseur(int nb, int diviseur) {
        return nb % diviseur == 0;
    }

    public static void main(String[] args) {
        System.out.println("Exo01:");
        System.out.println(estDiviseur(10, 2)); // true
        System.out.println(estDiviseur(10, 3)); // false
    }

}
