public class User {

    private String login;
    private String password;
    private String confirmPassword;

    public User(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public static void checkData(User user) throws WrongLoginException, WrongPasswordException {
        String line = user.getLogin().toLowerCase();
        if (wrongIndex(line) == -1 || validData(line)) {
            throw new WrongLoginException("Некорректный логин");
        } else {
            line = user.getPassword().toLowerCase();
            if (wrongIndex(line) == -1 || validData(line)) {
                throw new WrongPasswordException("Некорректный пароль");
            } else if (!user.getPassword().equals(user.getConfirmPassword())) {
                throw new WrongPasswordException("Пароли не совпадают");
            } else {
                System.out.println("User " + user.getLogin() + ": successful access");
            }
        }
    }

    public static int wrongIndex(String str) {
        int indexChar;
        int wrongIndex = 0;
        String defaultChars = "abcdefghijklmnopqrstuvwxyz12345678_";
        char[] strArr = str.toCharArray();
        for (char c : strArr) {
            indexChar = defaultChars.indexOf(c);
            if (indexChar == -1) {
                wrongIndex = -1;
            }
        }
        return wrongIndex;
    }
    public static boolean validData (String str) {
        return str == null || str.isBlank() || str.isEmpty() || str.length() > 20;
    }
}


