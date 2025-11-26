package launaybecue_gregoire.tp8;

public class FilterIntGt5 implements Filter<Integer> {
  @Override
  public boolean matches(Integer obj) {
    return obj > 5;
  }
}