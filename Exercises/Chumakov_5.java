import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TimeZone;


public class Chumakov_5 {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println();

        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("B4", "C3"));
        System.out.println(spiderVsFly("A2", "C4"));
        System.out.println(spiderVsFly("A2", "G4"));
        System.out.println(spiderVsFly("A3", "C2"));
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

    
    public static double doubleArrayMin(double[] arr){
        double min = arr[0];
        for (int i = 0; i<arr.length; i++){
            if (arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }

    public static String spiderVsFly(String spider, String fly) {
        int spiderX = spider.charAt(0) - 65;
        int spiderY = spider.charAt(1) - 48;
        int flyX = fly.charAt(0) - 65;
        int flyY = fly.charAt(1) - 48; 
        

                                               

        double pathCalculation1 = spiderY + flyY; 
        double pathCalculation2 = Math.abs(spiderY - flyY) + ((spiderX + flyX)* flyY) ;
        double pathCalculation3 = Math.abs(spiderY - flyY) + (Math.abs(7-spiderX - flyX) * flyY) ;
        double pathCalculation4 = Math.abs(spiderY - flyY) + (Math.abs(spiderX - flyX)  * flyY)  ;
    
        double[] pathArray = {pathCalculation1, pathCalculation2, pathCalculation3,pathCalculation4};

        String path = "";

        if (doubleArrayMin(pathArray) == pathCalculation1) {
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
        else if(doubleArrayMin(pathArray) == pathCalculation2){
            for (int i = 0; i < Math.abs(spiderY - flyY); i++) {
                path += spider.charAt(0);
                if (spiderY > flyY) path += spiderY - i;
                else path += spiderY + i;
                path += '-';
            }
            for (int i = 0; i <= Math.abs(spiderX - flyX); i++) {
                path += (char)(65 + (spiderX + i) % 8);
                path += fly.charAt(1);
                path += '-';
            }

        }
        else if(doubleArrayMin(pathArray) == pathCalculation3){
            for (int i = 0; i < Math.abs(spiderY - flyY); i++) {
                path += spider.charAt(0);
                if (spiderY > flyY) path += spiderY - i;
                else path += spiderY + i;
                path += '-';
            }
            for (int i = 0; i <= Math.abs(spiderX - flyX); i++) {
                if ((spiderX + i) - 8 <= 0)  {
                    path += (char)(65 + 8 + (spiderX - i) % 8);
                }
                if ((spiderX + i) - 8 > 0) {
                    path += (char)(65 + (spiderX - i) % 8);
                }
                path += fly.charAt(1);
                path += '-';
            }
            
        }
        else if(doubleArrayMin(pathArray) == pathCalculation4){
            for (int i = 0; i < Math.abs(spiderY - flyY); i++) {
                path += spider.charAt(0);
                if (spiderY > flyY) path += spiderY - i;
                else path += spiderY + i;
                path += '-';
            }
            for (int i = 0; i <= Math.abs(spiderX - flyX); i++) {
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

    

   public static String timeDifference(String city1, String firstDate, String city2) {
        String answer = "";

        int time1 = timeZone(city1);
        int time2 = timeZone(city2);
        int deltaTime = time2 - time1;
        int deltaHour = deltaTime / 60;
        int deltaMinute = deltaTime % 60;

        String[] words = firstDate.split(" ");
        int month = monthIndex(words[0]);
        int day = Integer.parseInt(words[1].replace(",", ""));
        int year = Integer.parseInt(words[2]);
        String[] time = words[3].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        int newYear = year;
        int newMonth = month;
        int newDay = day;
        int newHour = hour + deltaHour;
        int newMinute = minute + deltaMinute;

        if (newMinute < 0) {
            newMinute += 60;
            newHour -= 1;
        }
        else if (newMinute >= 60) {
            newMinute -= 60;
            newHour += 1;
        }

        if (newHour < 0) {
            newHour += 24;
            newDay -= 1;
        }
        else if (newHour >= 24) {
            newHour -= 24;
            newDay += 1;
        }

        if (newDay == 0) {
            newMonth -= 1;
            if (newMonth == 0) {
                newMonth = 12;
                newYear -= 1;
            }
            newDay = dayInMonth(newMonth, newYear);
        }
        else if (newDay > dayInMonth(newMonth, newYear)) {
            newMonth += 1;
            if (newMonth == 13) {
                newMonth = 1;
                newYear += 1;
            }
            newDay = 1;
        }

        String strMinute;
        if (newMinute < 10) {
            strMinute = "0" + newMinute;
        }
        else {
            strMinute = Integer.toString(newMinute);
        }

        String strHour;
        if (newHour < 10) {
            strHour = "0" + newHour;
        }
        else {
            strHour = Integer.toString(newHour);
        }
        answer = newYear + "-" + newMonth + "-" + newDay + " " + strHour + ":" + strMinute;
        return answer;
    }

    public static int timeZone(String city) {
        int time = 0;
        switch (city) {
            case "Los Angeles" -> time = -8 * 60;
            case "New York" -> time = -5 * 60;
            case "Caracas" -> time = -(4 * 60 + 30);
            case "Buenos Aires" -> time = -3 * 60;
            case "London" -> time = 0;
            case "Rome" -> time = 60;
            case "Moscow" -> time = 3 * 60;
            case "Tehran" -> time = 3 * 60 + 30;
            case "New Delhi" -> time = 5 * 60 + 30;
            case "Beijing" -> time = 8 * 60;
            case "Canberra" -> time = 10 * 60;
        }
        return time;
    }

    public static int monthIndex(String month) {
        int index = 0;
        switch (month) {
            case "January" -> index = 1;
            case "February" -> index = 2;
            case "March" -> index = 3;
            case "April" -> index = 4;
            case "May" -> index = 5;
            case "June" -> index = 6;
            case "July" -> index = 7;
            case "August" -> index = 8;
            case "September" -> index = 9;
            case "October" -> index = 10;
            case "November" -> index = 11;
            case "December" -> index = 12;
        }
        return index;
    }

    public static int dayInMonth(int monthIndex, int year) {
        int days = 0;
        switch (monthIndex) {
            case 1, 3, 5, 7, 8, 10, 12 -> days = 31;
            case 4, 6, 9, 11 -> days = 30;
            case 2 -> {
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    days = 29;
                }
                else {
                    days = 28;
                }
            }
        }
        return days;
    }

     public static boolean isNew(int numb) {
        String strNumb = Integer.toString(numb);
        int[] numbs = new int[strNumb.length()];
        String numbWithoutZeros = strNumb.replace("0", "");
        int[] numbsWithoutZeros = new int[numbWithoutZeros.length()];
        int j = 0;
        for (int i = 0; i < strNumb.length(); i++) {
            int nowNumb = Integer.parseInt(strNumb.substring(i, i + 1));
            if (nowNumb != 0) {
                numbsWithoutZeros[j] = nowNumb;
                j += 1;
            }
            numbs[i] = nowNumb;
        }
        Arrays.sort(numbs);
        Arrays.sort(numbsWithoutZeros);
        StringBuilder minNumb = new StringBuilder(Integer.toString(numbsWithoutZeros[0]));
        int index = numbs.length - numbsWithoutZeros.length;
        for (int i = 0; i < numbs.length; i++) {
            if (i != index) minNumb.append(numbs[i]);
        }
        return strNumb.contentEquals(minNumb);
    }
}

