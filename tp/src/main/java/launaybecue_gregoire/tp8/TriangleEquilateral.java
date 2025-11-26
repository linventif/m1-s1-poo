package launaybecue_gregoire.tp8;

public class TriangleEquilateral extends FormeGeometrique {
  private double cote;

  public TriangleEquilateral(double cote) {
    this.cote = cote;
  }

  @Override
  double calculerAire() {
    return (Math.sqrt(3) / 4) * cote * cote;
  }
}
