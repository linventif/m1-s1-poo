package launaybecue_gregoire.tp1;

public class AppProgImpJava {
    /*
     * Zone pour les sous-programmes.
     */

    /**
     * Retourne si un nombre entier est diviseur d’un autre.
     */
    public static boolean estDiviseur(int nb, int diviseur) {
        return nb % diviseur == 0;
    }

    /*
     * Programme principal.
     */
    public static void main(String[] args) {
        // 1) Retourne si un nombre entier est diviseur d’un autre.
        System.out.println(estDiviseur(10, 2)); // true
        System.out.println(estDiviseur(10, 3)); // false
    }

} /*----- Fin de la classe AppProgImpJava -----*/
