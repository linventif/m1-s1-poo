package launaybecue_gregoire.tp4;

public class Vault<TYPE_CONTENT> {
  private final int MAX_TRYS = 3;
  private final int CODE;
  private int trys;
  private boolean lock;
  private TYPE_CONTENT content;

  public Vault(int code, TYPE_CONTENT content) {
    this.CODE = code;
    this.trys = 0;
    this.content = content;
  }

  private void ResetVault() {
    this.trys = 0;
    this.lock = false;
    this.content = null;
    System.out.println("Vault reseted");
  }

  public void Lock() {
    this.lock = true;
  }

  public boolean Unlock(int code) {
    if (!this.lock) {
      System.out.println("Vault is already unlocked");
      return true;
    }
    if (this.CODE != code) {
      this.trys++;
      if (this.trys >= MAX_TRYS) {
        this.ResetVault();
      }
      System.out.println("Wrong Code");
      throw new RuntimeException("Wrong Code");
    }

    this.lock = false;
    System.out.println("Vault unlocked");
    return true;
  }

  public TYPE_CONTENT GetContent() {
    if (this.lock) {
      throw new RuntimeException("Vault is locked");
    }
    return this.content;
  }

  public static void main(String[] args) {
    Vault<String> vault = new Vault<>(1234, "Secret Content");
    vault.Lock();

    try {
      vault.Unlock(1111);
    } catch (RuntimeException e) {
    }

    try {
      vault.Unlock(1111);
    } catch (RuntimeException e) {
    }
    try {
      vault.Unlock(1111);
    } catch (RuntimeException e) {
    }

    try {
      vault.Unlock(1234);
      System.out.println("Vault unlocked successfully.");
      System.out.println("Content: " + vault.GetContent());
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }
}
