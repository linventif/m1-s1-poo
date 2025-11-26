package launaybecue_gregoire.tp8;

public class Carre extends FormeGeometrique {
  private double cote;

  public Carre(double cote) {
    this.cote = cote;
  }

  @Override
  double calculerAire() {
    return cote * cote;
  }
}
