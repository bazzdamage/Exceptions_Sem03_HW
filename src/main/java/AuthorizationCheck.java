public class AuthorizationCheck {

    public static boolean isAuthorizationValid(String login, String password, String confirmPassword) {
        if (!isLoginValid(login)) {
            try {
                throw new WrongLoginException("Login is invalid");
            } catch (WrongLoginException e) {
                throw new RuntimeException(e);
            }
        } else if (!isPasswordValid(password)) {
            try {
                throw new WrongPasswordException("Password is invalid");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        } else if (!password.equals(confirmPassword)) {
            try {
                throw new WrongPasswordException("Password not match");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        } else return true;
    }

    private static boolean isLoginValid(String login) {
        if (login.isEmpty() || login.length() > 20) {
            return false;
        } else return login.matches("\\w+");
    }

    private static boolean isPasswordValid(String password) {
        if (password.isEmpty() || password.length() > 20) {
            return false;
        } else return password.matches("\\w+");
    }

}
