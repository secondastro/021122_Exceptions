
public class Main {
    public static void main(String[] args) {
        Data.check("Витька", "123456", "123456");
        Data.check("Victor", "123456", "12346");
        Data.check("Victoria", "123456AAA", "123456AAA");
        }
}