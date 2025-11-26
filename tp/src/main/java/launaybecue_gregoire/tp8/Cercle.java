package launaybecue_gregoire.tp8;

public class Cercle extends FormeGeometrique {
  private double rayon;

  public Cercle(double rayon) {
    this.rayon = rayon;
  }

  @Override
  double calculerAire() {
    return Math.PI * rayon * rayon;
  }
}
