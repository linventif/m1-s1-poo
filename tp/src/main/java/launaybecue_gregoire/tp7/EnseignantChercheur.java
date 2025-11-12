package launaybecue_gregoire.tp7;

public class EnseignantChercheur extends Enseignant {
  private double NB_HEURES_MAX = 192;
  private double SALAIRE_BASE = 2500;
  private double PRIX_HEURE_SUPP = 40;

  public EnseignantChercheur(String nom, String prenom, double nbHeures) {
    super(nom, prenom, nbHeures);
  }

  @Override
  public double calculerSalaire() {
    return SALAIRE_BASE
        + (nbHeures > NB_HEURES_MAX ? (nbHeures - NB_HEURES_MAX) * PRIX_HEURE_SUPP : 0);
  }
}
