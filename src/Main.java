
public class Main {
    public static void main(String[] args) {
        User one = new User("", "12345678","12345678");
        User two = new User("петька", "", "2");
        User three = new User("Logan", "12345567", "12345678");
        User four = new User("Lager", "123456", "123456");

        check(one,two,three,four);


        }
    public static void check(User... users) {
        for (User user : users) {
            try {
                User.checkData(user);
            } catch (WrongLoginException e) {
                System.out.println(e.getMessage() + " " +  '"' + user.getLogin() + '"');

            } catch (WrongPasswordException e)  {
                System.out.println("пользователь " + user.getLogin() + ": " +  e.getMessage());
            }

        }
    }

}