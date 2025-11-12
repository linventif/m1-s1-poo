package launaybecue_gregoire.tp7;

public abstract class Parking {
  protected int capacite;
  protected Vehicule[] places;
  protected String type;
  protected Ferry ferry;

  public Parking(int capacite, String type, Ferry ferry) {
    this.capacite = capacite;
    this.type = type;
    places = new Vehicule[capacite];
    this.ferry = ferry;
  }

  public boolean canBoard(Vehicule v) {
    return ferry.canBoard(v);
  }

  public abstract boolean embark(Vehicule v);

  public abstract Vehicule disembark();

  public abstract Vehicule disembark(Vehicule v);

  public static void main(String[] args) {
    Ferry ferry = new Ferry(10000);

    Parking garage = new ParkingGarage(10, 2.5, ferry);
    Parking couloir = new ParkingCouloir(10, 3.0, ferry);
    Parking exterieur = new ParkingExterieur(20, ferry);

    Voiture voiture1 = new Voiture("Voiture 01", 1.8, 1200, 4);
    Bus bus1 = new Bus("Bus 01", 3.5, 5000, 50, 1000);
    Camion camion1 = new Camion("Camion 01", 3.2, 8000, 15000);

    System.out.println("Embarquement voiture1 dans le garage : " + garage.embark(voiture1));
    System.out.println("Embarquement bus1 dans le couloir : " + couloir
        .embark(bus1));
    System.out.println("Embarquement camion1 à l'extérieur : " + exterieur
        .embark(camion1));

    System.out.println("Débarquement voiture1 du garage : " + garage.disembark(voiture1));
    System.out.println("Débarquement bus1 du couloir : " + couloir.disembark());
    System.out.println("Débarquement camion1 de l'extérieur : " + exterieur.disembark());

  }
}
