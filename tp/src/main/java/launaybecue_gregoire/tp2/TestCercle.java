package launaybecue_gregoire.tp2;

public class TestCercle {
  public static void main(String[] args) {
    System.out.println("=== Test de la classe Cercle ===\n");

    // Test des constructeurs
    System.out.println("1. Test des constructeurs:");
    Cercle c1 = new Cercle(); // Constructeur par défaut
    Cercle c2 = new Cercle(new Point(3, 4), 5);
    Cercle c3 = new Cercle(0, 0, 3);

    System.out.println("c1 (défaut): " + c1);
    System.out.println("c2 (centre(3,4), rayon=5): " + c2);
    System.out.println("c3 (centre(0,0), rayon=3): " + c3);
    System.out.println();

    // Test des getters et setters
    System.out.println("2. Test des getters et setters:");
    System.out.println("Centre de c2: " + c2.getCentre());
    System.out.println("Rayon de c2: " + c2.getRayon());

    c2.setCentre(new Point(1, 1));
    c2.setRayon(4);
    System.out.println("c2 après modification: " + c2);
    System.out.println();

    // Test du périmètre et de la surface
    System.out.println("3. Test du périmètre et de la surface:");
    System.out.printf("Périmètre de c3 (rayon=3): %.2f\n", c3.perimetre());
    System.out.printf("Surface de c3 (rayon=3): %.2f\n", c3.surface());
    System.out.println();

    // Test de l'appartenance d'un point au cercle
    System.out.println("4. Test de l'appartenance d'un point:");
    Point p1 = new Point(0, 0); // Centre du cercle c3
    Point p2 = new Point(2, 0); // À distance 2 du centre (rayon=3)
    Point p3 = new Point(5, 0); // À distance 5 du centre (rayon=3)

    System.out.println("c3: " + c3);
    System.out.println("Point p1(0,0) dans c3? " + c3.contientPoint(p1)); // true
    System.out.println("Point p2(2,0) dans c3? " + c3.contientPoint(p2)); // true
    System.out.println("Point p3(5,0) dans c3? " + c3.contientPoint(p3)); // false
    System.out.println();

    // Test des intersections entre cercles
    System.out.println("5. Test des intersections:");
    Cercle c4 = new Cercle(4, 0, 2); // Centre(4,0), rayon=2
    Cercle c5 = new Cercle(10, 0, 1); // Centre(10,0), rayon=1

    System.out.println("c3: " + c3 + " (centre(0,0), rayon=3)");
    System.out.println("c4: " + c4 + " (centre(4,0), rayon=2)");
    System.out.println("c5: " + c5 + " (centre(10,0), rayon=1)");

    System.out.println("c3 intersecte avec c4? " + c3.intersecteAvec(c4)); // true (distance=4, rayons=3+2=5)
    System.out.println("c3 intersecte avec c5? " + c3.intersecteAvec(c5)); // false (distance=10, rayons=3+1=4)
    System.out.println("c4 intersecte avec c5? " + c4.intersecteAvec(c5)); // false (distance=6, rayons=2+1=3)
    System.out.println();

    // Test de l'englobement
    System.out.println("6. Test de l'englobement:");
    Cercle c6 = new Cercle(1, 1, 1); // Petit cercle
    Cercle c7 = new Cercle(0, 0, 5); // Grand cercle

    System.out.println("c6: " + c6 + " (centre(1,1), rayon=1)");
    System.out.println("c7: " + c7 + " (centre(0,0), rayon=5)");

    System.out.println("c7 contient c6? " + c7.contient(c6)); // true
    System.out.println("c6 contient c7? " + c6.contient(c7)); // false
    System.out.println("c3 contient c6? " + c3.contient(c6)); // Distance entre centres = sqrt(2) ≈ 1.41, rayon c6 = 1,
                                                              // rayon c3 = 3
    System.out.println();

    // Test equals et hashCode
    System.out.println("7. Test equals et hashCode:");
    Cercle c8 = new Cercle(0, 0, 3);
    Cercle c9 = new Cercle(0, 0, 3);

    System.out.println("c3: " + c3);
    System.out.println("c8: " + c8);
    System.out.println("c9: " + c9);
    System.out.println("c3.equals(c8)? " + c3.equals(c8)); // true
    System.out.println("c8.equals(c9)? " + c8.equals(c9)); // true
    System.out.println("c3.hashCode() == c8.hashCode()? " + (c3.hashCode() == c8.hashCode())); // true
    System.out.println();

    // Test avec des cercles concentriques
    System.out.println("8. Test avec des cercles concentriques:");
    Cercle petit = new Cercle(5, 5, 2);
    Cercle grand = new Cercle(5, 5, 8);

    System.out.println("Petit: " + petit);
    System.out.println("Grand: " + grand);
    System.out.println("Le grand contient le petit? " + grand.contient(petit)); // true
    System.out.println("Ils s'intersectent? " + grand.intersecteAvec(petit)); // true
    System.out.println();

    // Test avec des valeurs négatives pour le rayon
    System.out.println("9. Test avec rayon négatif:");
    Cercle c10 = new Cercle(0, 0, -5);
    System.out.println("Cercle avec rayon négatif (-5): " + c10); // Le rayon devrait être converti en positif
    System.out.println();

    // Test de cas limites pour les intersections
    System.out.println("10. Test de cas limites:");
    Cercle c11 = new Cercle(0, 0, 2);
    Cercle c12 = new Cercle(4, 0, 2); // Cercles tangents extérieurement
    Cercle c13 = new Cercle(1, 0, 1); // Cercles tangents intérieurement

    System.out.println("c11: " + c11);
    System.out.println("c12: " + c12);
    System.out.println("c13: " + c13);
    System.out.println("c11 et c12 tangents extérieurement? " + c11.intersecteAvec(c12)); // true
    System.out.println("c11 et c13 tangents intérieurement? " + c11.intersecteAvec(c13)); // true
    System.out.println("c11 contient c13? " + c11.contient(c13)); // true

    int ab = 10;

    System.out.println("Test variable ab = " + ab); // Just to use the variable and avoid warnings
  }
}