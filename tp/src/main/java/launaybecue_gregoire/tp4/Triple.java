package launaybecue_gregoire.tp4;

public class Triple<TYPE_FIRST, TYPE_SECOND, TYPE_THIRD> {
  /*----- Propriétés -----*/
  private TYPE_FIRST first;
  private TYPE_SECOND second;
  private TYPE_THIRD third;

  /*----- Constructeur -----*/
  public Triple(TYPE_FIRST frt, TYPE_SECOND scd, TYPE_THIRD thd) {
    this.first = frt;
    this.second = scd;
    this.third = thd;
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

  public TYPE_THIRD getThird() {
    return this.third;
  }

  public void setThird(TYPE_THIRD third) {
    this.third = third;
  }
}
