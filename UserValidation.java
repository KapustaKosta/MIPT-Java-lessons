public class UserValidation {

  public static boolean validate(String login, String password, String confirmPassword) {
    try {
      if (!login.matches("[a-zA-Z0-9_]{1,20}")) {
        throw new WrongLoginException(
            "Login должен содержать только латинские буквы, цифры и знак подчеркивания. Длина login должна быть меньше 20 символов.");
      }
      if (!password.matches("[a-zA-Z0-9_]{1,20}")) {
        throw new WrongPasswordException(
            "Password должен содержать только латинские буквы, цифры и знак подчеркивания. Длина password должна быть меньше 20 символов.");
      }
      if (!password.equals(confirmPassword)) {
        throw new WrongPasswordException("Password и confirmPassword должны быть равны");
      }
      return true;
    } catch (WrongLoginException | WrongPasswordException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
}

class WrongLoginException extends Exception {

  public WrongLoginException() {
    super();
  }

  public WrongLoginException(String message) {
    super(message);
  }
}

class WrongPasswordException extends Exception {

  public WrongPasswordException() {
    super();
  }

  public WrongPasswordException(String message) {
    super(message);
  }
}