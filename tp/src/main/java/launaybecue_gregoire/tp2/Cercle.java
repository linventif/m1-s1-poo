package launaybecue_gregoire.tp2;

public class Cercle {
    private Point centre;
    private double rayon;

    // Constructeur par défaut
    public Cercle() {
        this.centre = new Point();
        this.rayon = 1.0;
    }

    // Constructeur avec centre et rayon
    public Cercle(Point centre, double rayon) {
        this.centre = new Point(centre.getAbscisse(), centre.getOrdonnee());
        this.rayon = Math.abs(rayon); // Le rayon doit être positif
    }

    // Constructeur avec coordonnées du centre et rayon
    public Cercle(double x, double y, double rayon) {
        this.centre = new Point(x, y);
        this.rayon = Math.abs(rayon);
    }

    // Getters
    public Point getCentre() {
        return new Point(centre.getAbscisse(), centre.getOrdonnee()); // Retourne une copie
    }

    public double getRayon() {
        return rayon;
    }

    // Setters
    public void setCentre(Point centre) {
        this.centre = new Point(centre.getAbscisse(), centre.getOrdonnee());
    }

    public void setRayon(double rayon) {
        this.rayon = Math.abs(rayon);
    }

    // Méthode pour calculer le périmètre
    public double perimetre() {
        return 2 * Math.PI * rayon;
    }

    // Méthode pour calculer la surface
    public double surface() {
        return Math.PI * rayon * rayon;
    }

    // Vérifier si un point appartient au cercle
    public boolean contientPoint(Point point) {
        return centre.distance(point) <= rayon;
    }

    // Vérifier si ce cercle a une intersection avec un autre cercle
    public boolean intersecteAvec(Cercle autre) {
        double distanceCentres = centre.distance(autre.centre);
        return distanceCentres <= (rayon + autre.rayon) && distanceCentres >= Math.abs(rayon - autre.rayon);
    }

    // Vérifier si ce cercle contient/englobe un autre cercle
    public boolean contient(Cercle autre) {
        double distanceCentres = centre.distance(autre.centre);
        return (distanceCentres + autre.rayon) <= rayon;
    }

    @Override
    public String toString() {
        return "Cercle{centre=" + centre + ", rayon=" + rayon + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cercle cercle = (Cercle) obj;
        return Double.compare(cercle.rayon, rayon) == 0 && centre.equals(cercle.centre);
    }

    @Override
    public int hashCode() {
        int result = centre.hashCode();
        long temp = Double.doubleToLongBits(rayon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}