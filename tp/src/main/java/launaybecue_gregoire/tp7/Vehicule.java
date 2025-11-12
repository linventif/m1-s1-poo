package launaybecue_gregoire.tp7;

import java.util.HashMap;

public class Vehicule {
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
  }
}