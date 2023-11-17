public class Chumakov_5 {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABCBA", "CDEDC"));
        System.out.println(spiderVsFly("H3", "E2"));

        System.out.println(spiderVsFly("A4", "B2"));

        System.out.println(spiderVsFly("A4", "C2"));

    }
    public static boolean sameLetterPattern(String str1, String str2){
        if (str1.length() != str2.length())
            return false;

        if (str1.equals(str2))
            return true;
        
        int startIndex1 = str1.charAt(0);
        int startIndex2 = str2.charAt(0);
        
        if (startIndex1 >= startIndex2){
            int diff = startIndex1 - startIndex2;
            for (int i = 0; i<str1.length();i++){    
                if (Character.getNumericValue(str1.charAt(i))- diff != Character.getNumericValue(str2.charAt(i)))
                    return false;
            }
        }
        else{
            int diff = startIndex2 - startIndex1;
            for (int i = 0; i<str1.length();i++){    
                if (Character.getNumericValue(str2.charAt(i))- diff != Character.getNumericValue(str1.charAt(i)))
                    return false;
            }
        }
        
        return true;
    }
    public static String spiderVsFly(String spider, String fly) {
        int spiderX = spider.charAt(0) - 65;
        int spiderY = spider.charAt(1) - 48;
        int flyX = fly.charAt(0) - 65;
        int flyY = fly.charAt(1) - 48; // я не знаю ак но из-за того что я сделал перевод в инт теперь вот так

        double pathCalculation1 = spiderY + flyY;
        double pathCalculation2 = Math.abs(spiderY - flyY) + ((spiderX + flyX) % 8) * flyY * 0.76536686473;

        String path = "";

        if (pathCalculation1 <= pathCalculation2) {
            for (int i = 0; i < spiderY; i++) {
                path += spider.charAt(0);
                path += spiderY - i;
                path += '-';
            }
            path += "A0-";
            for (int i = 0; i < flyY; i++) {
                path += fly.charAt(0);
                path += i + 1;
                path += '-';
            }
        } 
        else{
            for (int i = 0; i < Math.abs(spiderY - flyY); i++) {
                path += spider.charAt(0);
                if (spiderY > flyY) path += spiderY - i;
                else path += spiderY + i;
                path += '-';
            }
            for (int i = 0; i <= (spiderX + flyX) % 8; i++) {
                path += (char)(65 + (spiderX + i) % 8);
                path += fly.charAt(1);
                path += '-';
            }
        }

        return path.substring(0, path.length() - 1);
    }
}
