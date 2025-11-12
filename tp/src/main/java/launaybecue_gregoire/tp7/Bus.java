package launaybecue_gregoire.tp7;

public class Bus extends Vehicule {
  private int nombrePassagers;
  private double poidsBagages;
  private final double POIDS_PAR_PASSAGER = 75.0;

  public Bus(String nom, double hauteur, double poids, int nombrePassagers, double poidsBagages) {
    super(nom, hauteur, poids);
    this.nombrePassagers = nombrePassagers;
    this.poidsBagages = poidsBagages;
  }

  @Override
  public double calculerCharge() {
    return poids + (nombrePassagers * POIDS_PAR_PASSAGER) + poidsBagages;
  }
}
