package launaybecue_gregoire.tp7;

public class Voiture extends Vehicule {
  private int nombrePassagers;
  static final double POIDS_PAR_PASSAGER = 75.0;

  public Voiture(String nom, double hauteur, double poids, int nombrePassagers) {
    super(nom, hauteur, poids);
    this.nombrePassagers = nombrePassagers;
  }

  @Override
  public double calculerCharge() {
    return poids + (nombrePassagers * 100);
  }
}
