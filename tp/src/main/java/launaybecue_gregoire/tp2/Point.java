package launaybecue_gregoire.tp2;

public class Point {
  private double abscisse;
  private double ordonnee;

  public Point() {
    this.abscisse = 0;
    this.ordonnee = 0;
  }

  public Point(double abscisse, double ordonnee) {
    this.abscisse = abscisse;
    this.ordonnee = ordonnee;
  }

  public double getAbscisse() {
    return abscisse;
  }

  public double getOrdonnee() {
    return ordonnee;
  }

  public void setAbscisse(double abscisse) {
    this.abscisse = abscisse;
  }

  public void setOrdonnee(double ordonnee) {
    this.ordonnee = ordonnee;
  }

  public void translate(double deltaX, double deltaY) {
    this.abscisse += deltaX;
    this.ordonnee += deltaY;
  }

  public double distance(Point other) {
    double deltaX = this.abscisse - other.abscisse;
    double deltaY = this.ordonnee - other.ordonnee;
    return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
  }

  public double distanceFromOrigin() {
    return Math.sqrt(abscisse * abscisse + ordonnee * ordonnee);
  }

  @Override
  public String toString() {
    return "(" + abscisse + ", " + ordonnee + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Point point = (Point) obj;
    return Double.compare(point.abscisse, abscisse) == 0 && Double.compare(point.ordonnee, ordonnee) == 0;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    temp = Double.doubleToLongBits(abscisse);
    result = (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(ordonnee);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }
}
