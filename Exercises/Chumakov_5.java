import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;


public class Chumakov_5 {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println();

        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println();

        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println();

        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"},
                "tossed"));
        System.out.println();

        System.out.println(sumsUp(new int[]{1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[]{1, 2, 3, 7, 9}));
        System.out.println(sumsUp(new int[]{10, 9, 7, 2, 8}));
        System.out.println(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}));
        System.out.println();

        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
        System.out.println();

        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
        System.out.println();

        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println();

        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        
        System.out.println();

        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));

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
     public static int _digitsCount(long number) {
        if (number == 0) return 0;
        return 1 + _digitsCount(number / 10);
    }

    public static int digitsCount(long number) {
        return 1 + _digitsCount(number / 10);
    }

    

    public static int[] getCharset(String word) { //getCharset - метод, который создает массив из входящего слова
        int[] charset = new int[127];
        for (char c : word.toCharArray()) //toCharArray()  - преобразование строки в массив
            charset[c]++;
        return charset;
    }

    public static int totalPoints(String[] words, String scramble) {
        int points = 0;
        int[] scrambleCharset = getCharset(scramble); //посимвольный массив изначального слова
        for (int i = 0; i < words.length; i++) {
            int[] wordCharset = getCharset(words[i]); //посимвольный массив получившегося слова
            boolean good = true;
            for (int j = 0; j < 127; j++)
                if (wordCharset[j] > scrambleCharset[j]) {
                    good = false;
                    break;
                }
            if (good) {
                points += words[i].length() - 2;
                if (words[i].length() == 6) points += 50;
            }
        }
        return points;
    }

	

    public static String sumsUp(int[] nums) {
        LinkedList<String> answer = new LinkedList<>();
        LinkedList<Integer> numsBefore = new LinkedList<>();
        
        for (int num: nums) {
            for(int i = 0; i < numsBefore.size(); i++) {
                int numBefore = numsBefore.get(i);
                if (num + numBefore == 8) {
                    answer.add(Arrays.toString(new int[] {Math.min(num, numBefore), Math.max(num, numBefore)}));
                    numsBefore.remove(i);
                    continue;
                }
            }
            numsBefore.add(num);
        }
        return Arrays.toString(answer.toArray());
    }



    public static String takeDownAverage(String[] percents) {
        int a = 0;
        for (String s : percents)
            a += Integer.parseInt(s.substring(0, s.length() -1));
        return (a / percents.length - percents.length*5 - 5) + "%";
    }

   
    public static String caesarCipher(String mode, String str, int rot) {
        StringBuilder answer = new StringBuilder();
        if (mode.equalsIgnoreCase("encode")) {
                for (char symbol : str.toCharArray()) {
                    if ('a' <= symbol && symbol <= 'z') {
                        char newSymbol = (char) (symbol - 32 + rot);
                        if (newSymbol > 'Z') newSymbol = (char) (newSymbol - 26);
                        answer.append(newSymbol);
                    } else {
                        answer.append(symbol);
                    }
                }
            }
             else if (mode.equalsIgnoreCase("decode")){
                for (char symbol : str.toCharArray()) {
                    if ('a' <= symbol && symbol <= 'z') {
                        char newSymbol = (char) (symbol - 32 - rot);
                        if (newSymbol < 'A') newSymbol = (char) (newSymbol + 26);
                        answer.append(newSymbol);
                    } else {
                        answer.append(symbol);
                    }
                }
            }
        
        return answer.toString();
    }
    


    

    public static int setSetup(int n, int k) {
        if (k == 1) {
            return n;
        }
        return n * setSetup(n - 1, k - 1);
    }

    

    public static SimpleDateFormat parseDate = new SimpleDateFormat("MMMM d, yyyy HH:mm");
    public static SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-M-d HH:mm");


    public static String getGMT(String city) {
        if (city == "Los Angeles") return "GMT-08:00";
        if (city == "New York") return "GMT-05:00";
        if (city == "Caracas") return "GMT- 04:30";
        if (city == "Buenos Aires") return "GMT-03:00";
        if (city == "London") return "GMT00:00";
        if (city == "Rome") return "GMT+01:00";
        if (city == "Moscow") return "GMT+03:00";
        if (city == "Tehran") return "GMT+03:30";
        if (city == "New Delhi") return "GMT+05:30";
        if (city == "Beijing") return "GMT+08:00";
        if (city == "Canberra") return "GMT+10:00";
        return "GMT";
    }

    

    public static Integer[] splitNumber(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        while (n > 0) {
            res.add(n % 10);
            n /= 10;
        }
        return res.toArray(new Integer[res.size()]);
    }

    public static boolean isNew(int n) {
        Integer[] num = splitNumber(n);
        for (int i = 0; i < num.length - 1; i++)
            if (num[i] > 0 && num[i] < num[num.length - 1])
                return false;
        return true;
    }


}

