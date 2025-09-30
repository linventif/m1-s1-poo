package launaybecue_gregoire.tp3;

/**
 * Classe FIFO pour gérer une liste d'attente d'appels téléphoniques
 * First In First Out - Les premiers arrivés sont les premiers servis
 */
public class FIFO {
  private String[] auditeurs; // Tableau pour stocker les noms des auditeurs
  private int debut; // Index du premier élément dans la queue
  private int fin; // Index où ajouter le prochain élément
  private int taille; // Nombre d'éléments actuellement dans la queue
  private int capacite; // Capacité maximale de la queue

  /**
   * Constructeur avec capacité fixe
   *
   * @param capacite Capacité initiale de la liste d'attente
   */
  public FIFO(int capacite) {
    if (capacite <= 0) {
      throw new IllegalArgumentException("La capacité doit être positive");
    }
    this.capacite = capacite;
    this.auditeurs = new String[capacite];
    this.debut = 0;
    this.fin = 0;
    this.taille = 0;
  }

  /**
   * Vérifie si la liste d'attente est pleine
   *
   * @return true si pleine, false sinon
   */
  public boolean estPleine() {
    return taille == capacite;
  }

  /**
   * Vérifie si la liste d'attente est vide
   *
   * @return true si vide, false sinon
   */
  public boolean estVide() {
    return taille == 0;
  }

  /**
   * Retourne le nombre d'auditeurs en attente
   *
   * @return nombre d'auditeurs
   */
  public int getTaille() {
    return taille;
  }

  /**
   * Retourne la capacité de la liste d'attente
   *
   * @return capacité
   */
  public int getCapacite() {
    return capacite;
  }

  /**
   * Ajoute un auditeur à la liste d'attente (version de base)
   *
   * @param nom Nom de l'auditeur
   * @return true si ajouté avec succès, false si la liste est pleine
   */
  public boolean ajouterAuditeur(String nom) {
    if (nom == null || nom.trim().isEmpty()) {
      System.out.println("Erreur : nom d'auditeur invalide");
      return false;
    }

    if (estPleine()) {
      System.out.println("Liste d'attente pleine ! " + nom + " ne peut pas être ajouté.");
      return false;
    }

    auditeurs[fin] = nom.trim();
    fin = (fin + 1) % capacite; // Gestion circulaire
    taille++;
    System.out.println(nom + " a été ajouté à la liste d'attente (position " + taille + ")");
    return true;
  }

  /**
   * Ajoute un auditeur avec extension automatique de capacité si nécessaire
   * (question 5)
   *
   * @param nom Nom de l'auditeur
   * @return true si ajouté avec succès
   */
  public boolean ajouterAuditeurAvecExtension(String nom) {
    if (nom == null || nom.trim().isEmpty()) {
      System.out.println("Erreur : nom d'auditeur invalide");
      return false;
    }

    if (estPleine()) {
      doublerCapacite();
      System.out.println("Capacité doublée pour accueillir " + nom);
    }

    auditeurs[fin] = nom.trim();
    fin = (fin + 1) % capacite;
    taille++;
    System.out.println(nom + " a été ajouté à la liste d'attente (position " + taille + ")");
    return true;
  }

  /**
   * Met en ligne le prochain auditeur avec l'animateur (retire le premier de la
   * queue)
   *
   * @return nom de l'auditeur mis en ligne, null si la liste est vide
   */
  public String mettreEnLigne() {
    if (estVide()) {
      System.out.println("Aucun auditeur en attente");
      return null;
    }

    String auditeur = auditeurs[debut];
    auditeurs[debut] = null; // Libération de la mémoire
    debut = (debut + 1) % capacite; // Gestion circulaire
    taille--;
    System.out.println(auditeur + " est maintenant en ligne avec l'animateur");
    return auditeur;
  }

  /**
   * Supprime un auditeur de la liste d'attente (quand il raccroche)
   *
   * @param nom Nom de l'auditeur à supprimer
   * @return true si supprimé avec succès, false si non trouvé
   */
  public boolean supprimerAuditeur(String nom) {
    if (nom == null || estVide()) {
      return false;
    }

    // Recherche de l'auditeur dans la queue
    for (int i = 0; i < taille; i++) {
      int index = (debut + i) % capacite;
      if (nom.equals(auditeurs[index])) {
        // Décalage des éléments suivants vers la gauche
        for (int j = i; j < taille - 1; j++) {
          int currentIndex = (debut + j) % capacite;
          int nextIndex = (debut + j + 1) % capacite;
          auditeurs[currentIndex] = auditeurs[nextIndex];
        }
        // Mise à jour des indices
        fin = (fin - 1 + capacite) % capacite;
        auditeurs[fin] = null;
        taille--;
        System.out.println(nom + " a raccroché et a été retiré de la liste d'attente");
        return true;
      }
    }

    System.out.println(nom + " n'a pas été trouvé dans la liste d'attente");
    return false;
  }

  /**
   * Double la capacité de la liste d'attente (question 5)
   */
  private void doublerCapacite() {
    int nouvelleCapacite = capacite * 2;
    String[] nouveauTableau = new String[nouvelleCapacite];

    // Copie des éléments existants dans le bon ordre
    for (int i = 0; i < taille; i++) {
      nouveauTableau[i] = auditeurs[(debut + i) % capacite];
    }

    auditeurs = nouveauTableau;
    debut = 0;
    fin = taille;
    capacite = nouvelleCapacite;
    System.out.println("Capacité étendue à " + capacite + " places");
  }

  /**
   * Affiche l'état actuel de la liste d'attente
   */
  public void afficherListeAttente() {
    System.out.println("\n=== État de la liste d'attente ===");
    System.out.println("Capacité : " + capacite);
    System.out.println("Auditeurs en attente : " + taille);

    if (estVide()) {
      System.out.println("Aucun auditeur en attente");
    } else {
      System.out.println("File d'attente (du plus ancien au plus récent) :");
      for (int i = 0; i < taille; i++) {
        int index = (debut + i) % capacite;
        System.out.println("  " + (i + 1) + ". " + auditeurs[index]);
      }
    }
    System.out.println("================================\n");
  }

  /**
   * Programme principal pour tester la structure de données (question 4)
   */
  public static void main(String[] args) {
    System.out.println("=== Test de la liste FIFO d'attente téléphonique ===\n");

    // Test avec capacité fixe (questions 3 et 4)
    System.out.println("--- Test avec capacité fixe (3 places) ---");
    FIFO listeAttente = new FIFO(3);

    // Test d'ajout normal
    listeAttente.ajouterAuditeur("Alice");
    listeAttente.ajouterAuditeur("Bob");
    listeAttente.ajouterAuditeur("Charlie");
    listeAttente.afficherListeAttente();

    // Test d'ajout quand la liste est pleine
    listeAttente.ajouterAuditeur("David"); // Doit être refusé

    // Test de mise en ligne
    listeAttente.mettreEnLigne(); // Alice passe en ligne
    listeAttente.afficherListeAttente();

    // Ajout possible maintenant
    listeAttente.ajouterAuditeur("David");
    listeAttente.afficherListeAttente();

    // Test de suppression (auditeur raccroche)
    listeAttente.supprimerAuditeur("Bob");
    listeAttente.afficherListeAttente();

    // Test de plusieurs mises en ligne
    listeAttente.mettreEnLigne(); // Charlie
    listeAttente.mettreEnLigne(); // David
    listeAttente.afficherListeAttente();

    // Test sur liste vide
    listeAttente.mettreEnLigne(); // Doit afficher un message d'erreur

    System.out.println("\n--- Test avec extension automatique de capacité ---");
    FIFO listeAvecExtension = new FIFO(2);

    // Remplissage initial
    listeAvecExtension.ajouterAuditeurAvecExtension("Emma");
    listeAvecExtension.ajouterAuditeurAvecExtension("Frank");
    listeAvecExtension.afficherListeAttente();

    // Déclenchement de l'extension
    listeAvecExtension.ajouterAuditeurAvecExtension("Grace"); // Doit doubler la capacité
    listeAvecExtension.ajouterAuditeurAvecExtension("Henry");
    listeAvecExtension.afficherListeAttente();

    // Test de fonctionnement après extension
    listeAvecExtension.mettreEnLigne(); // Emma
    listeAvecExtension.supprimerAuditeur("Grace");
    listeAvecExtension.afficherListeAttente();

    System.out.println("=== Fin des tests ===");
  }
}
