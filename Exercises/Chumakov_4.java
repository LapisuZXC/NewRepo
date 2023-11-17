import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


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
        System.out.println(alphabeticRow("abcdjuwx") );
        System.out.println(alphabeticRow("klmabzyxw")); 
        System.out.println(lettersCount("asdfaffasfsddassda"));
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println(uniqueSubstring("23141132"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(shortestWay(array1));
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng") );
        System.out.println(switchNums(519, 723));
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
        String[] array = new String[arg.length()+1];
        for (int j = 0; j<arg.length();j++){
            array[j] = (String.valueOf(arg.charAt(j)));
        }
        String result = "";
        Set<String> set = new HashSet<>();
        char[] c = arg.toCharArray();
        for (char ch : c){
            set.add(String.valueOf(ch));
        }
        String[] uniqueChars = set.toArray(new String[0]);
        for (int i = 0; i< uniqueChars.length;i++){
            
            int count = Collections.frequency(Arrays.asList(array), uniqueChars[i]);
            result+= uniqueChars[i] + String.valueOf(count);
        }
        return result;
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
    public static int switchNums(int num1, int num2) {
        char[] arr1 = String.valueOf(num1).toCharArray();
        char[] arr2 = String.valueOf(num2).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = arr1.length - 1, j = 0; i >= 0 && j < arr2.length; i--, j++) {
            arr2[j] = arr1[i];
        }
        int result = Integer.parseInt(String.valueOf(arr2));
        return result;
    }
    
}


