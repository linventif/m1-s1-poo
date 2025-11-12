package launaybecue_gregoire.tp7;

public class ParkingExterieur extends Parking {
  public ParkingExterieur(int capacite, Ferry ferry) {
    super(capacite, "exterieur", ferry);
  }

  @Override
  public boolean embark(Vehicule v) {
    for (int i = 0; i < capacite; i++) {
      if (places[i] == null) {
        places[i] = v;
        return true;
      }
    }
    return false;
  }

  @Override
  public Vehicule disembark(Vehicule v) {
    for (int i = 0; i < capacite; i++) {
      if (places[i] != null && places[i].equals(v)) {
        places[i] = null;
        return v;
      }
    }
    return null;
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
}