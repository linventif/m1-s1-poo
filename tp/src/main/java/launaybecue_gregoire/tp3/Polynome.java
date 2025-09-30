package launaybecue_gregoire.tp3;

import java.util.Arrays;

public class Polynome {
  private int[] coeffs; // coeffs[i] = coefficient de x^i

  // Constructeur à partir d'un tableau de coefficients
  public Polynome(int[] coeffs) {
    // On enlève les zéros à la fin pour ne pas fausser le degré
    int deg = coeffs.length - 1;
    while (deg > 0 && coeffs[deg] == 0) {
      deg--;
    }
    this.coeffs = Arrays.copyOf(coeffs, deg + 1);
  }

  // Degré du polynôme
  public int degre() {
    return coeffs.length - 1;
  }

  // Test d’égalité
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Polynome))
      return false;
    Polynome other = (Polynome) obj;
    return Arrays.equals(this.coeffs, other.coeffs);
  }

  // Évaluer p(x)
  public int eval(int x) {
    int res = 0;
    int puissance = 1; // x^0
    for (int c : coeffs) {
      res += c * puissance;
      puissance *= x;
    }
    return res;
  }

  // Somme de 2 polynômes (nouvel objet)
  public Polynome somme(Polynome other) {
    int n = Math.max(this.coeffs.length, other.coeffs.length);
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      int c1 = (i < this.coeffs.length) ? this.coeffs[i] : 0;
      int c2 = (i < other.coeffs.length) ? other.coeffs[i] : 0;
      result[i] = c1 + c2;
    }
    return new Polynome(result);
  }

  // Ajouter un polynôme à this
  public void ajouter(Polynome other) {
    int n = Math.max(this.coeffs.length, other.coeffs.length);
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      int c1 = (i < this.coeffs.length) ? this.coeffs[i] : 0;
      int c2 = (i < other.coeffs.length) ? other.coeffs[i] : 0;
      result[i] = c1 + c2;
    }
    this.coeffs = result;
  }

  // Chercher les racines entières dans [a, b]
  public void racinesEntieres(int a, int b) {
    System.out.println("Racines entières entre " + a + " et " + b + " :");
    boolean trouve = false;
    for (int x = a; x <= b; x++) {
      if (this.eval(x) == 0) {
        System.out.println("  x = " + x);
        trouve = true;
      }
    }
    if (!trouve) {
      System.out.println("  Aucune racine entière trouvée.");
    }
  }

  // Affichage
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = coeffs.length - 1; i >= 0; i--) {
      if (coeffs[i] != 0) {
        if (sb.length() > 0 && coeffs[i] > 0)
          sb.append(" + ");
        if (i == 0)
          sb.append(coeffs[i]);
        else if (i == 1)
          sb.append(coeffs[i]).append("x");
        else
          sb.append(coeffs[i]).append("x^").append(i);
      }
    }
    return sb.toString();
  }

  // --- Programme de test ---
  public static void main(String[] args) {
    Polynome p1 = new Polynome(new int[] { 7, -5, 2 }); // 2x² - 5x + 7
    Polynome p2 = new Polynome(new int[] { 3, 1 }); // x + 3

    System.out.println("p1(x) = " + p1);
    System.out.println("p2(x) = " + p2);

    // Degré
    System.out.println("Degré de p1 : " + p1.degre());

    // Évaluation
    System.out.println("p1(2) = " + p1.eval(2));

    // Somme
    Polynome somme = p1.somme(p2);
    System.out.println("p1 + p2 = " + somme);

    // Ajout en place
    p1.ajouter(p2);
    System.out.println("Après p1 += p2, p1 = " + p1);

    // Racines entières
    Polynome p3 = new Polynome(new int[] { 6, -5, 1 }); // x² - 5x + 6 = (x-2)(x-3)
    System.out.println("p3(x) = " + p3);
    p3.racinesEntieres(0, 10);
  }
}
