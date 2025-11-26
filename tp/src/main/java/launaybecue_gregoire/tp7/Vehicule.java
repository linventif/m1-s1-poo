package launaybecue_gregoire.tp7;

import java.util.Arrays;

public class Vehicule implements Comparable<Vehicule> {
  public static final int POIDS_PAR_PASSAGER = 75;
  protected String nom;
  protected double hauteur;
  protected double poids;

  public Vehicule(String nom, double hauteur, double poids) {
    this.nom = nom;
    this.hauteur = hauteur;
    this.poids = poids;
  }

  public double calculerCharge() {
    return poids;
  }

  public double getHauteur() {
    return hauteur;
  }

  public double getPoids() {
    return poids;
  }

  public String toString() {
    return nom + " (hauteur: " + hauteur + " m, poids: " + poids + " kg)";
  }

  public int compareTo(Vehicule v) {
    return Double.compare(getHauteur(), v.getHauteur());
  }

  public static void main(String[] args) {
    /*----- Déclaration et instanciation du ferry -----*/
    Vehicule[] ferry = new Vehicule[5];

    ferry[0] = new Bus("Bus 01", 3.5, 5000, 50, 1000);
    ferry[1] = new Voiture("Voiture 02", 1.7, 1000, 3);
    ferry[2] = new Voiture("Voiture 03", 1.9, 1000, 1);
    ferry[3] = new Camion("Camion 04", 3.0, 6000, 10000);
    ferry[4] = new Bus("Bus 05", 3, 4000, 55, 2000);

    /*----- Calcul de la charge totale embarquée -----*/
    double chargeTotale = 0;
    for (int i = 0; i < ferry.length; i++)
      chargeTotale += ferry[i].calculerCharge();

    System.out.println("Charge totale : " + chargeTotale);

    System.out.println("\n=== Véhicules embarqués sur le ferry ===");
    for (int i = 0; i < ferry.length; i++)
      System.out.println(ferry[i]);

    // sort ferry
    Arrays.sort(ferry);

    System.out.println("\n=== Véhicules embarqués sur le ferry (triés par hauteur) ===");
    for (int i = 0; i < ferry.length; i++)
      System.out.println(ferry[i]);
  }
}