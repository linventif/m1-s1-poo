package launaybecue_gregoire.tp8;

public class FilterString implements Filter<String> {
  @Override
  public boolean matches(String obj) {
    return obj.length() > 3;
  }
}
