package launaybecue_gregoire.tp8;

import java.util.ArrayList;
import java.util.List;

import launaybecue_gregoire.tp7.Bus;
import launaybecue_gregoire.tp7.Camion;
import launaybecue_gregoire.tp7.Vehicule;
import launaybecue_gregoire.tp7.Voiture;
import launaybecue_gregoire.tp7.FilterVehicule;

public class AppFilter {
  /*----- Méthode générique pour filtrer une liste de données -----*/
  public static <T> List<T> filterList(List<T> elts, Filter<T> filtre) {
    List<T> result = new ArrayList<>();

    for (T e : elts)
      if (filtre.matches(e))
        result.add(e);

    return result;
  }

  /*----- Programme principal -----*/
  public static void main(String[] args) {
    List<Integer> nbs = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    System.out.println(AppFilter.filterList(nbs, new FilterIntGt5()));

    // on string
    List<String> mots = List.of("un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf", "dix");
    List<String> motsFiltres = AppFilter.filterList(mots, new FilterString());
    System.out.println(motsFiltres);

    // on vehicule
    List<Vehicule> vehicules = List.of(
        new Voiture("Voiture A", 1.5, 1200, 4),
        new Bus("Bus B", 3.2, 8000, 40, 5000),
        new Camion("Camion C", 3.5, 15000, 20000),
        new Voiture("Voiture D", 1.7, 1300, 5));
    List<Vehicule> vehiculesFiltres = AppFilter.filterList(vehicules, new FilterVehicule());
    System.out.println(vehiculesFiltres);
  }
}