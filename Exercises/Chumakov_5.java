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
        int sx = spider.charAt(0) - 65;
        int sy = spider.charAt(1) - 48;
        int fx = fly.charAt(0) - 65;
        int fy = fly.charAt(1) - 48; // я не знаю ак но из-за того что я сделал перевод в инт теперь вот так

        double strategyDist1 = sy + fy;
        double strategyDist2 = Math.abs(sy - fy) + ((sx + fx) % 8) * fy * 0.76536686473;

        String path = "";

        if (strategyDist1 <= strategyDist2) {
            for (int i = 0; i < sy; i++) {
                path += spider.charAt(0);
                path += sy - i;
                path += '-';
            }
            path += "A0-";
            for (int i = 0; i < fy; i++) {
                path += fly.charAt(0);
                path += i + 1;
                path += '-';
            }
        } else {
            for (int i = 0; i < Math.abs(sy - fy); i++) {
                path += spider.charAt(0);
                if (sy > fy) path += sy - i;
                else path += sy + i;
                path += '-';
            }
            for (int i = 0; i <= (sx + fx) % 8; i++) {
                path += (char)(65 + (sx + i) % 8);
                path += fly.charAt(1);
                path += '-';
            }
        }

        return path.substring(0, path.length() - 1);
    }
}
