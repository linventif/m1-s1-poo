package launaybecue_gregoire.tp7;

public class ParkingCouloir extends Parking {
  private double hauteurLimite;

  public ParkingCouloir(int capacite, double hauteurLimite, Ferry ferry) {
    super(capacite, "couloir", ferry);
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
    for (int i = 0; i < capacite; i++) {
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
    for (int i = 0; i < capacite; i++) {
      if (places[i] != null && places[i].equals(v)) {
        if (i == 0 || places[i - 1] == null) {
          places[i] = null;
          return v;
        } else {
          return null;
        }
      }
    }
    return null;
  }
}