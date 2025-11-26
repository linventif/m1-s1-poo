package launaybecue_gregoire.tp7;

import launaybecue_gregoire.tp8.Filter;

public class FilterVehicule implements Filter<Vehicule> {
  @Override
  public boolean matches(Vehicule obj) {
    return obj.getPoids() > 3000;
  }
}
