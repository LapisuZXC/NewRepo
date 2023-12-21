package LR5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrefConvertor {
    public static String convert(String str) {
        Pattern pattern1 = Pattern.compile("\\b(?<!https?://)\\w+\\.\\w+");
        Matcher matcher1 = pattern1.matcher(str);
        if (matcher1.find()) {
            return matcher1.replaceAll("http://" + matcher1.group());
        }
        return str;
    }
}