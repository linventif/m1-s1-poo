package launaybecue_gregoire.tp7;

public class Camion extends Vehicule {
  private double chargeUtile;

  public Camion(String immatriculation, double poidsVide, double puissance, double chargeUtile) {
    super(immatriculation, poidsVide, puissance);
    this.chargeUtile = chargeUtile;
  }

  @Override
  public double calculerCharge() {
    return poids + chargeUtile;
  }
}
