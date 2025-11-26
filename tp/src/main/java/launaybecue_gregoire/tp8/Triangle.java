package launaybecue_gregoire.tp8;

public class Triangle extends FormeGeometrique {
  private double base;
  private double hauteur;

  public Triangle(double base, double hauteur) {
    this.base = base;
    this.hauteur = hauteur;
  }

  @Override
  double calculerAire() {
    return (base * hauteur) / 2;
  }
}
