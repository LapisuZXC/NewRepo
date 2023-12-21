package LR5;


    
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void numberFinder(String text) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}


