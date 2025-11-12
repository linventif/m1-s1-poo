package launaybecue_gregoire.tp7;

public class ParkingGarage extends Parking {
  private double hauteurLimite;

  public ParkingGarage(int capacite, double hauteurLimite, Ferry ferry) {
    super(capacite, "garage", ferry);
    this.hauteurLimite = hauteurLimite;
  }

  @Override
  public boolean embark(Vehicule v) {
    if (v.getHauteur() > hauteurLimite) {
      return false;
    }
    for (int i = 0; i < capacite; i++) {
      if (places[i] == null) {
        places[i] = v;
        return true;
      }
    }
    return false;
  }

  @Override
  public Vehicule disembark() {
    for (int i = capacite - 1; i >= 0; i--) {
      if (places[i] != null) {
        Vehicule v = places[i];
        places[i] = null;
        return v;
      }
    }
    return null;
  }

  @Override
  public Vehicule disembark(Vehicule v) {
    for (int i = capacite - 1; i >= 0; i--) {
      if (places[i] != null && places[i].equals(v)) {
        places[i] = null;
        return v;
      }
    }
    return null;
  }
}