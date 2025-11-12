package launaybecue_gregoire.tp7;

public class Vacataire extends Enseignant {
  public static double PRIX_HEURE = 40;
  private char dernierDiplome;

  public Vacataire(String nom, String prenom, double nbHeures, char dernierDiplome) {
    super(nom, prenom, nbHeures);
    this.dernierDiplome = dernierDiplome;
  }

  @Override
  public double calculerSalaire() {
    return nbHeures * PRIX_HEURE;
  }
}
