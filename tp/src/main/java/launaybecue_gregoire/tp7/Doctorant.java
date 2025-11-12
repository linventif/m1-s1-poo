package launaybecue_gregoire.tp7;

public class Doctorant extends Vacataire {
  private double NB_HEURES_MAX = 96;

  public Doctorant(String nom, String prenom, double nbHeures) {
    super(nom, prenom, nbHeures, 'M');
  }

  @Override
  public double calculerSalaire() {
    double nbHeuresCapped = Math.min(nbHeures, NB_HEURES_MAX);
    return nbHeuresCapped * Vacataire.PRIX_HEURE;
  }
}
