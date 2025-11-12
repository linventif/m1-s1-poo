package launaybecue_gregoire.tp4;

public class Tuple<TYPE_FIRST, TYPE_SECOND> {
  /*----- Propriétés -----*/
  private TYPE_FIRST first;
  private TYPE_SECOND second;

  /*----- Constructeur -----*/
  public Tuple(TYPE_FIRST frt, TYPE_SECOND scd) {
    this.first = frt;
    this.second = scd;
  }

  /*----- Méthodes -----*/
  public TYPE_FIRST getFirst() {
    return this.first;
  }

  public void setFirst(TYPE_FIRST first) {
    this.first = first;
  }

  public TYPE_SECOND getSecond() {
    return this.second;
  }

  public void setSecond(TYPE_SECOND second) {
    this.second = second;
  }
}
