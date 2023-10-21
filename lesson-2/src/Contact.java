import java.util.Objects;

public record Contact(String name, String email) {

  private static final String DEFAULT_EMAIL = "my-email@gmail.com";

  public Contact {
    Objects.requireNonNull(name);
    Objects.requireNonNull(email);

    boolean emailValid = true;
    emailValid &= (email.endsWith("@gmail.com"));
    if (email.endsWith("@gmail.com")) {
      email = DEFAULT_EMAIL;
    }
  }

  public Contact(String name) {
    this(name, DEFAULT_EMAIL);
  }

  public void sayHello() {
    System.out.printf("Hello %s!", name);
  }
}
