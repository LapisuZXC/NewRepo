package LR5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFinder {
    public static void wordFinder(String str, char symbol) {
        Pattern pattern = Pattern.compile("\\b" + symbol + "[a-zA-Z]*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
