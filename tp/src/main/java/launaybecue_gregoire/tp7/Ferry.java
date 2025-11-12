package launaybecue_gregoire.tp7;

public class Ferry {
  public static double TONAGE_MAX;
  private double tonnageActuel;

  public Ferry(double tonnageMax) {
    this.TONAGE_MAX = tonnageMax;
  }

  public boolean canBoard(Vehicule v) {
    if (tonnageActuel + v.getPoids() <= TONAGE_MAX) {
      tonnageActuel += v.getPoids();
      return true;
    }
    return false;
  }

  public void disembark(Vehicule v) {
    tonnageActuel -= v.getPoids();
  }

  public void embark(Vehicule v) {
    tonnageActuel += v.getPoids();
  }
}
