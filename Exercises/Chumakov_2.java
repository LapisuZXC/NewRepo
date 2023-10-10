
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;
public class Chumakov_2 {

    public static void main(String[] args) {
        // System.out.println();
        int[] int_array_1 = {44, 32, 86, 19};
        int[] int_array_2 = {22, 50, 16, 63, 31, 55};
        int[] int_array_3 = {1,2,3,4,5};
        int[] int_array_4 = {1,2,3,4,6};
        int[] int_array_5 = {1,2,3};
        int[] int_array_6 = {3,3,-2,408,3,31};
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println(getInintials("Barack Obama"));
        System.out.println(getInintials("Ryan Gosling"));
        System.out.println(differenceEvenOdd(int_array_1));
        System.out.println(differenceEvenOdd(int_array_2));
        System.out.println(equalToAvg(int_array_3));
        System.out.println(equalToAvg(int_array_4));
        System.out.println(indexMult(int_array_5));
        System.out.println(indexMult(int_array_6));
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Hello, I’m under the water, please helps me"));
        System.out.println(botHelper("Hello, I’m under the water, please helper me"));
        System.out.println(botHelper("Hello, I’m under the water, please help, me"));
        System.out.println(botHelper("help me"));
        System.out.println(botHelper("help"));
        //System.out.println(botHelper("help"));
        //System.out.println(botHelper("help"));
        //System.out.println(botHelper("help"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println(isAnagram("listen", "netsil"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }

    public static boolean duplicateChars(String word){
        char[] charArray = word.toCharArray();
        Set<String> set = new HashSet<>();
        for (char ch : charArray){
            String lch = String.valueOf(ch).toLowerCase();
            if (!set.add(lch)){
                return true;
            }
        }
        return false;
        
    }

    public static String getInintials(String full_name){
        int index = full_name.indexOf(" ");                                         // с расчётом что у нас умный чел,
        return String.valueOf(String.valueOf(full_name.charAt(0)) + String.valueOf(full_name.charAt((index + 1)))); // который в программу будет вводить только то, что ну;но а не например "р2ш1ргш2р123щш";
    }

    public static int differenceEvenOdd(int[] intarray){
        int even = 0;
        int odd = 0;
        for (int i : intarray)
        {
            if (i % 2 == 0)
            {
                even = even + i;
            }
            else
            {
                odd = odd + i;
            }
        }
        return Math.abs(even - odd);

    }

    public static boolean equalToAvg(int[] intarray){
        double sum = 0;
        for (int i : intarray)
        {
            sum += i;
        }
        sum = sum/intarray.length;
        for (double i : intarray)
        {
            if (i == sum)
            {
                return true;
            }
        }
        return false;
    }

    public static String indexMult(int[] numbers) {
        int[] multipliedArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            multipliedArray[i] = numbers[i] * i;
        }
        return Arrays.toString(multipliedArray);
    }

    public static String reverse(String str){
        String result = "";
        for (int i = (str.length()-1); i >= 0; i--)
        {
            result += String.valueOf(str.charAt(i));
        }
        return result;
    }

    public static int Tribonacci(int arg){
        
        if (arg==0 || arg==1)
        {
            return 0;
        }
        else if(arg == 2)
        {
            return 1;
        }
        else{
            int int_1 = 0;
            int int_2 = 0;
            int int_3 = 1;
            int result = 0;
            for (int i = 3; i < arg; i++)
            {
                result = int_1 + int_2 + int_3;
                int_1 = int_2;
                int_2 = int_3;
                int_3 = result;
            }  
            return result;
            }
           
    }

    public static String pseudoHash(int hash_length){
        String result = "";
        Random random = new Random();
        for (int i = 0; i < hash_length;i++){
            int letter_or_number_decider = random.nextInt(2);
            if (letter_or_number_decider == 0)
            {
                result += String.valueOf(random.nextInt(10));
            }
            else
            {
                result += String.valueOf((char)(random.nextInt(26) + 'A')).toLowerCase();
            }
        }
        return result;
    }

    public static String botHelper(String message){
        message.toLowerCase();
        if (message.replaceAll("\\p{Punct}"," ").contains(" help ") || message..replaceAll("\\p{Punct}"," ").startsWith("help ", 0)   || message.replaceAll("\\p{Punct}"," ").endsWith(" help") || message.equals("help")) {
            return "Calling for a staff member";
        }
        else{
            return "Keep waiting";
        }
    }
    public static boolean isAnagram(String input1, String input2) {
        input1 = input1.replaceAll("\\s", "").toLowerCase();
        input2 = input2.replaceAll("\\s", "").toLowerCase();
        char[] charArray1 = input1.toCharArray(); 
        char[] charArray2 = input2.toCharArray();
        Arrays.sort(charArray1); 
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2); 
    }
}