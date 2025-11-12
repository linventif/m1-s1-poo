package launaybecue_gregoire.tp7;

public abstract class Enseignant {
  protected String nom;
  protected String prenom;
  protected double nbHeures;

  public Enseignant(String nom, String prenom, double nbHeures) {
    this.nom = nom;
    this.prenom = prenom;
    this.nbHeures = nbHeures;
  }

  public abstract double calculerSalaire();

  public static void main(String[] args) {
    Enseignant e1 = new Vacataire("Dupont", "Jean", 100, 'B');
    Enseignant e2 = new Doctorant("Martin", "Claire", 150);
    Enseignant e3 = new EnseignantChercheur("Durand", "Paul", 200);

    System.out.println("Salaire de " + e1.nom + " " + e1.prenom + ": " + e1.calculerSalaire());
    System.out.println("Salaire de " + e2.nom + " " + e2.prenom + ": " + e2.calculerSalaire());
    System.out.println("Salaire de " + e3.nom + " " + e3.prenom + ": " + e3.calculerSalaire());
  }
}
