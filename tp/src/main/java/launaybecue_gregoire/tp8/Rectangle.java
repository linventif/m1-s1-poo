package launaybecue_gregoire.tp8;

public class Rectangle extends FormeGeometrique {
  private double longueur;
  private double largeur;

  public Rectangle(double longueur, double largeur) {
    this.longueur = longueur;
    this.largeur = largeur;
  }

  @Override
  double calculerAire() {
    return longueur * largeur;
  }
}
