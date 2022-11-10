public class Data {

    private Data() {

    }

    public static void validate(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String line = login.toLowerCase();
        if (wrongIndex(line) == -1 || validData(line)) {
            throw new WrongLoginException("Некорректный логин");
        } else {
            line = password.toLowerCase();
            if (wrongIndex(line) == -1 || validData(line)) {
                throw new WrongPasswordException("Некорректный пароль");
            } else if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            } else {
                System.out.println("User " + login + ": successful access");
            }
        }
    }

    public static void check (String login, String password, String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage() + " " + '"' + login + '"');

        } catch (WrongPasswordException e) {
            System.out.println("пользователь " + login + ": " + e.getMessage());
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

    public static boolean validData(String str) {
        return str == null || str.isBlank() || str.isEmpty() || str.length() > 20;
    }
}


