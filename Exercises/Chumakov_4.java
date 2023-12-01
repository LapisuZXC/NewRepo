import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


import Hash.HashTable;

public class Chumakov_4{
    public static void main(String[] args) {
        int[][] array1 = {{1, 3, 1},{1, 5, 1},{4, 2, 1}};
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println(alphabeticRow("abcddcba") );
        System.out.println(alphabeticRow("klmabzyxw")); 
        System.out.println(lettersCount("aaavvvvaaaaaajj"));
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println(uniqueSubstring("23141132"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(shortestWay(array1));
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng") );
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259)); 
    }
    public static String nonRepeatable(String str) {
    if (str.equals("")){
        return str;
    }
    return str.charAt(0) + nonRepeatable(str.replaceAll(String.valueOf(str.charAt(0)), ""));
    }   
    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    public static void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        generateCombinations("", n, result);
        return result;
    }
    public static void generateCombinations(String current, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
    
        if (current.endsWith("0")) {
            generateCombinations(current + "1", n, result);
        } else {
            generateCombinations(current + "0", n, result);
            generateCombinations(current + "1", n, result);
        }
    }
    public static String alphabeticRow(String str) {
        String longestRow = "";
        String currentRow = "";
        String result = "";
    
        for (int i = 0; i < str.length() - 1; i++) {
            currentRow += str.charAt(i);
    
            if (str.charAt(i + 1) - str.charAt(i) == 1) {
                continue;
            }
    
            if (currentRow.length() > longestRow.length()) {
                longestRow = currentRow;
            }
    
            currentRow = "";
        }
        currentRow += str.charAt(str.length() - 1);
    
        if (currentRow.length() > longestRow.length()) {
            result = currentRow;
        }
        else result = longestRow;
        currentRow = "";
        longestRow = "";

        for (int i = str.length()-1; i > 0; i--) {
            currentRow += str.charAt(i);
    
            if (str.charAt(i-1) - str.charAt(i) == 1) {
                continue;
            }
    
            if (currentRow.length() > longestRow.length()) {
                longestRow = currentRow;
            }
    
            currentRow = "";
        }
    
        currentRow += str.charAt(0);
    
        if (currentRow.length() > result.length())
            result = currentRow;
        else if (longestRow.length() > result.length())
            result = longestRow;
    
        return result;
    }
    
    public static String lettersCount(String arg){
        
        String result = "";
        
        
        String[] splited = arg.split("(?<=(.))(?!\\1)");
        
        for (String s: splited){
            Set<String> set = new HashSet<>();  
            String[] array = new String[s.length()+1];
            for (int j = 0; j<s.length();j++){
                array[j] = (String.valueOf(s.charAt(j)));
            }
            char[] c = s.toCharArray();
            for (char ch : c){
                set.add(String.valueOf(ch));
            }
            String[] uniqueChars = set.toArray(new String[0]);
            for (int i = 0; i< uniqueChars.length;i++){
            
                int count = Collections.frequency(Arrays.asList(array), uniqueChars[i]);
                result+= uniqueChars[i] + String.valueOf(count);
        }
        }
        String[] results = result.split("(?<=\\G.{" + 2 + "})");
        StringBuilder output = new StringBuilder();
        for (String p : results){
            output.append(p+ " ");
        }
        Map<Integer, String> wordMap = new TreeMap<>();
        for (String word : results) {
            int order = Integer.parseInt(word.replaceAll("[^0-9]", ""));
            wordMap.put(order, word);
        }

        StringBuilder resultt = new StringBuilder();
        for (String word : wordMap.values()) {
            resultt.append(word);
        }

        return resultt.toString().trim();
        
    }
    public static int convertToNum(String str){
        int result = 0;
        str.toLowerCase();
        
        String[] temp = str.split(" ");
            
        
        HashTable<String,Integer> nums = new HashTable<>(19);
        nums.put("zero",0);
        nums.put("one",1);
        nums.put("two",2);
        nums.put("three",3);
        nums.put("four",4);
        nums.put("five",5);
        nums.put("six",6);
        nums.put("seven",7);
        nums.put("eight",8);
        nums.put("nine",9);
        nums.put("ten",10);
        nums.put("eleven",11);
        nums.put("twelve",12);
        nums.put("thirteen",13);
        nums.put("fifty",15);
        nums.put("twenty",20);
        nums.put("thirty",30);
        nums.put("forty",40);
        nums.put("fifty",50);

        if (temp.length == 1) {
            if (nums.get(temp[0]) != null) {
                result += nums.get(temp[0]);
            }
            else if (nums.get(temp[0].replace("teen","")) != null){
                result += nums.get(temp[0]) + 10;
            }
            else if(nums.get(temp[0].replace("ty","")) != null){
                result += nums.get(temp[0]) * 10;
            }
            

        }
        else if(temp.length == 2){
            //boolean exeption1 = temp[1] != "twelve" || temp[1] != "thirteen" || temp[1] != "fifteen" || temp[1] != "twenty" || temp[1] != "thirty" || temp[1] != "forty" || temp[1] != "fifty" ;
            boolean exeption1 = !temp[0].equals("twelve") || !temp[0].equals("thirteen") || !temp[0].equals("fifteen");
            if (nums.get(temp[1]) != null & nums.get(temp[1]).toString().length() == 1) {
                result += nums.get(temp[1]);}
            if (nums.get(temp[0]) != null & exeption1 ){
                result += nums.get(temp[0]);
            }
            else if(nums.get(temp[0].replace("ty","")) != null){
                result += nums.get(temp[0].replace("ty","")) * 10;
            }
            else if(temp[0].equals("hundred") || temp[1].equals("hundreds")){
                result += nums.get(temp[0]) * 100;
            }
            
        }   
        else if (temp.length == 3){
            if (nums.get(temp[2]) != null & nums.get(temp[2]).toString().length() == 1) {
                result += nums.get(temp[2]);}
            if (temp[1].equals("hundred") || temp[1].equals("hundreds")){
                result += nums.get(temp[0] ) * 100;

            }
            
        }
        else if (temp.length == 4){
            if (nums.get(temp[3]) != null & nums.get(temp[3]).toString().length() == 1) {
                result += nums.get(temp[3]);
            }
            if (temp[1].equals("hundred") || temp[1].equals("hundreds")){
                result += nums.get(temp[0] ) * 100;
            }
            if(nums.get(temp[2].replace("ty","")) != null){
                result += nums.get(temp[2].replace("ty","")) * 10;
            
        }
    }
        return result;
    }
    
    public static String uniqueSubstring(String arg){
        Set<String> set = new HashSet<>();
        char[] c = arg.toCharArray();
        String result = "";
    
        for (char ch : c){
            if(!set.add(String.valueOf(ch))){
                break;
            }
            result += String.valueOf(ch);  
        }
        

        return result;
    }
    public static int shortestWay(int[][] array){
        int n = array.length;
        int result = array[0][0];
        int x = 1;
        int y = 0;
        for (int i = 1; i<n;i++){
            if (array[y][x] < array[x][y]){
                if (x<n){
                x++;
                result+= array[y][x];
                }
                else break;
            }
            else{
                if (y<n){
                y++;
                result+= array[x][y];
                }
                else break;
            }
        }
        return result;
    }
    public static String numericOrder(String string) {
        String[] words = string.split(" ");
        Map<Integer, String> wordMap = new TreeMap<>();

        for (String word : words) {
            int order = Integer.parseInt(word.replaceAll("[^0-9]", ""));
            wordMap.put(order, word);
        }

        StringBuilder result = new StringBuilder();
        for (String word : wordMap.values()) {
            result.append(word.replaceAll("[0-9]", "")).append(" ");
        }

        return result.toString().trim();
    }
    public static ArrayList<Integer> quicksort(ArrayList<Integer> arr) {
        if (arr.size() == 0) {
            return arr;
        }
        int axis = arr.get(0);
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        for (int i = 1; i < arr.size(); i++) {
            if (axis < arr.get(i)) {
                array1.add(arr.get(i));
            } else {
                array2.add(arr.get(i));
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>(quicksort(array1));
        result.add(axis);
        result.addAll(quicksort(array2));
        return result;
    }
    public static int switchNums(int a, int b) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while (a > 0){
            if (a%10 > 0) {
                digits.add(a % 10);
            }
            a /= 10;
        }
        digits = quicksort(digits);
        for (int i = 0; i < String.valueOf(b).length(); i++) {
            if (digits.get(0) > Character.getNumericValue(String.valueOf(b).charAt(i))) {
                char[] temp = String.valueOf(b).toCharArray();
                temp[i] = (char) (digits.get(0)+'0');
                b = Integer.parseInt(String.valueOf(temp));
                digits.remove(0);
            }
        }

        return b;
    }
    
}


