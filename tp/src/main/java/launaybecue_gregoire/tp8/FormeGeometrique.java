package launaybecue_gregoire.tp8;

public abstract class FormeGeometrique {

  abstract double calculerAire();

  public static void main(String[] args) {
    FormeGeometrique cercle = new Cercle(5);
    FormeGeometrique rectangle = new Rectangle(4, 6);
    FormeGeometrique triangle = new Triangle(3, 4);
    FormeGeometrique carre = new Carre(4);
    FormeGeometrique triangleEquilateral = new TriangleEquilateral(4);

    System.out.println("Aire du cercle : " + cercle.calculerAire());
    System.out.println("Aire du rectangle : " + rectangle.calculerAire());
    System.out.println("Aire du triangle : " + triangle.calculerAire());
    System.out.println("Aire du carré : " + carre.calculerAire());
    System.out.println("Aire du triangle équilatéral : " + triangleEquilateral.calculerAire());
  }
}
