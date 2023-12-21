package LR5;
import java.util.regex.*;

    
    public class NumberFinder {
        public static void main(String[] args) {
        String text = "The price of the product is $19.99";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
}
}
}
