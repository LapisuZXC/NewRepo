package LR5;

import java.util.regex.*;

public class CorrectPassword {
    public static boolean isCorrect(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])\\w{8,16}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}