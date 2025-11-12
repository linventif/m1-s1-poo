package launaybecue_gregoire.tp7;

public class Voiture extends Vehicule {
  private int nombrePassagers;

  public Voiture(String nom, double hauteur, double poids, int nombrePassagers) {
    super(nom, hauteur, poids);
    this.nombrePassagers = nombrePassagers;
  }

  @Override
  public double calculerCharge() {
    return poids + (nombrePassagers * 100);
  }
}
