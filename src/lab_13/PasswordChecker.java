package lab_13;
import java.util.Scanner;
import java.util.regex.Pattern;
public class PasswordChecker {
    public static void main(String[] args) {
        String pswd;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите пароль: ");
            pswd = scanner.next();
            if (Pattern.matches("\\w{8,}", pswd) &&
                    Pattern.matches(".*[A-Z]+.*", pswd) &&
                    Pattern.matches(".*[a-z]+.*", pswd) &&
                    Pattern.matches(".*\\d+.*", pswd))
                System.out.println("Пароль ±прокатит");
            else
                System.out.println("Пароль должен состоять из 8 и более букв латиницы (обоих регистров!) и\n" +
                        "цифр, он может содержать '_'");
        }
    }
}
