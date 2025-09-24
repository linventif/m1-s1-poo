package launaybecue_gregoire.tp2;

public class Main {
  public static void main(String[] args) {
    Point p1 = new Point(3, 4);
    Point p2 = new Point(3, 4);
    Point p3 = new Point(5, 6);

    System.out.println("Point 1: " + p1);
    System.out.println("Point 2: " + p2);
    System.out.println("Point 3: " + p3);

    System.out.println("p1 equals p2: " + p1.equals(p2)); // true
    System.out.println("p1 equals p3: " + p1.equals(p3)); // false

    System.out.println("Distance between p1 and p3: " + p1.distance(p3)); // ~2.828
    System.out.println("Distance from origin to p1: " + p1.distanceFromOrigin()); // 5.0

    p1.translate(1, 1);
    System.out.println("Point 1 after translation: " + p1); // (4, 5)

    /*
     * créer et initialiser aléatoirement un tableau de 20 points,
     * - rechercher puis afficher les 2 points les plus proches du tableau.
     */

    Point[] points = new Point[20];
    int aleaMult = 100;
    for (int i = 0; i < points.length; i++) {
      double x = Math.random() * aleaMult; // coordonnées aléatoires entre 0 et aleaMult
      double y = Math.random() * aleaMult;
      points[i] = new Point(x, y);
    }
    double minDistance = Double.MAX_VALUE;

    Point pointA = null;
    Point pointB = null;

    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        double distance = points[i].distance(points[j]);
        if (distance < minDistance) {
          minDistance = distance;
          pointA = points[i];
          pointB = points[j];
        }
      }
    }

    System.out.println(
        "Les deux points les plus proches sont : " + pointA + " et " + pointB + " avec une distance de " + minDistance);

    // display tableau of points
    System.out.println("Tableau des points in a 2d table :");
    int gridSize = 30;
    String[][] grid = new String[gridSize][gridSize];
    System.out.println("Points grid (each * represents a point):");

    // Top border
    System.out.print("+");
    for (int j = 0; j < gridSize; j++) {
      System.out.print("---");
    }
    System.out.println("+");

    for (int i = 0; i < gridSize; i++) {
      System.out.print("|"); // Left border

      for (int j = 0; j < gridSize; j++) {
        grid[i][j] = "   ";

        for (Point point : points) {
          int x = (int) Math.round(point.getAbscisse() / (aleaMult / gridSize));
          int y = (int) Math.round(point.getOrdonnee() / (aleaMult / gridSize));
          if (x == j && y == i) {
            if (point.equals(pointA) || point.equals(pointB)) {
              grid[i][j] = "\033[0;31m * \033[0m"; // Red color for closest points
            } else {
              grid[i][j] = " * ";
            }
            break;
          }
        }
      }

      System.out.print(String.join("", grid[i]));
      System.out.println("|"); // Right border
    }

    // Bottom border
    System.out.print("+");
    for (int j = 0; j < gridSize; j++) {
      System.out.print("---");
    }
    System.out.println("+");
  }
}