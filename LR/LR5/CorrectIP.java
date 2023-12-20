package LR5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrectIP {
    public static boolean isCorrect(String ip) {
        Pattern pattern = Pattern.compile("^([01]?\\d{1,2}|2[0-4]\\d|25[0-5])" +
                "(\\.([01]?\\d{1,2}|2[0-4]\\d|25[0-5])){3}$");
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}