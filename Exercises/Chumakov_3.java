import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Math;
public class Chumakov_3 {
    


    public static void main(String[] args){
        int[] inputArray1 = {1,-3,2};
        int[] inputArray2 = {2,5,2};
        int[] inputArray3 = {1,-6,9};
        String[][] inputArray4 = {{"Apple","Shop1","Shop2","Shop3","Shop4"},{"Banana","Shop2","Shop3","Shop4"},{"Orange","Shop1","Shop3","Shop4"},{"Pear","Shop2","Shop4"}};
        String[][] inputArray5 = {{"Fridge","Shop2","Shop3"},{"Microwave","Shop1","Shop2","Shop3","Shop4"},{"Laptop","Shop3","Shop4"},{"Phone","Shop1","Shop2","Shop3","Shop4"}};
        int[] inputArray6 = {3,1,4,2,7,5};
        int[] inputArray7 = {1,2,3,4,5};
        int[] inputArray8 = {1,2,-6,10,3};
        int[][] inputArray9 = {{1,2,3,4,5},{6,7,8,9,10},{5,5,5,5,5},{7,4,3,14,2},{1,0,11,10,1}};
        int[][] inputArray10 = {{6,4,19,0,0},{81,25,3,1,17},{48,12,60,32,14},{91,47,16,65,217},{5,73,0,4,21}};
        System.out.println(replaceVovels("apple"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println(doesBlockFit(1,3,5,4,5));
        System.out.println(doesBlockFit(1,8,1,1,1));
        System.out.println(doesBlockFit(1,2,2,1,1));
        System.out.println(doesBlockFit(4,2,3,1,6));
        System.out.println(numCheck(293));
        System.out.println(numCheck(52));
        System.out.println(countRoots(inputArray1));
        System.out.println(countRoots(inputArray2));
        System.out.println(countRoots(inputArray3));
        System.out.println(salesData(inputArray4));
        System.out.println(salesData(inputArray5));
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println(isWaveForm(inputArray6));
        System.out.println(isWaveForm(inputArray7));
        System.out.println(isWaveForm(inputArray8));
        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words"));
        System.out.println(Arrays.deepToString(dataScience(inputArray9)));
        System.out.println(Arrays.deepToString(dataScience(inputArray10)));
        //System.out.println();
    }
    public static String replaceVovels(String word){
        String vowels ="AEUIOaeuio";
        StringBuilder sb = new StringBuilder();
        for (char c :word.toCharArray()){
            if (vowels.contains(String.valueOf(c))){
                sb.append("*");
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static String stringTransform(String input) {
        Pattern pattern = Pattern.compile("(.)\\1"); 
        Matcher matcher = pattern.matcher(input); 
        StringBuffer output = new StringBuffer(); 

        while (matcher.find()) { 
            String group = matcher.group(1); 
            String replacement = "Double" + Character.toUpperCase(group.charAt(0)); //creating a string using mask Double* where * is letter uppercase in the group
            matcher.appendReplacement(output, replacement); 
        }
        matcher.appendTail(output); 

        return output.toString();
    }

    //??? 3-4 lines []
    //
    
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) { 
        int[] blockDimensions = {a, b, c}; 
        int[] holeDimensions = {w, h}; 
         
        Arrays.sort(blockDimensions); 
        Arrays.sort(holeDimensions); 
         
        return blockDimensions[0] <= holeDimensions[0] && blockDimensions[1] <= holeDimensions[1]; 
    } 

    public static boolean numCheck(int num){
        String numStr = String.valueOf(num);
        int digitSquaredSum = 0;
        for (int i =0; i< numStr.length()-1 ;i++){
            digitSquaredSum += Integer.valueOf(numStr.charAt(i));
        }
        return num % 2 == digitSquaredSum % 2;}
            

    public static int countRoots(int[] inputArray){
        double[] tempArray = new double[inputArray.length];
        
        for (int i = 0; i < inputArray.length; i++){
            tempArray[i] = (double) inputArray[i];
        }
        //System.out.println(Arrays.toString(tempArray));
        Double d = (tempArray[1] * tempArray[1])- (4 * tempArray[0] * inputArray[2]);
        Double x1 = (-(inputArray[1]) + Math.sqrt(d))/(2*inputArray[0]) ;
        Double x2 = (-(inputArray[1]) - Math.sqrt(d))/(2*inputArray[0]) ;
        if (d>0){
            if (x1 == (double)(x1.intValue()) && x2 == (double)(x2.intValue())){
                return 2;
            }
            if (x1 == (double)(x1.intValue()) ^ x2 == (double)(x2.intValue())){
                return 1;
            }
            else{
                return 0;
            }
        }
        else if (d==0){
            if (x1 == (double)(x1.intValue())){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
            
      
    }

    public static List<String> salesData(String[][] arg_array) {
        String[] lf = {"Shop1", "Shop2", "Shop3", "Shop4"};
        List<String> lookingFor = new ArrayList<>(Arrays.asList(lf));
        List<String> result = new ArrayList<>();
        for (String[] i : arg_array) {
            List<String> tempList = new ArrayList<>(Arrays.asList(i));
            if (tempList.containsAll(lookingFor)) {
                tempList.removeAll(lookingFor);
                result.add(tempList.toString());
            }
        }
        return result;
    }
    public static boolean validSplit(String sentence) {
        String[] words = sentence.split(" ");
        
        if (words.length == 0) {
            return false;
        }
        
        char lastLetter = Character.toLowerCase(words[0].charAt(words[0].length() - 1));
        
        for (int i = 1; i < words.length; i++) {
            char firstLetter = Character.toLowerCase(words[i].charAt(0));
            
            if (firstLetter != lastLetter) {
                return false;
            }
            
            lastLetter = Character.toLowerCase(words[i].charAt(words[i].length() - 1));
        }
        
        return true;
    }
    public static boolean isWaveForm(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        
        boolean increasing = arr[1] > arr[0];
        
        for (int i = 2; i < arr.length; i++) {
            if ((increasing && arr[i] >= arr[i - 1]) || (!increasing && arr[i] <= arr[i - 1])) {
                return false;
            }
            
            increasing = !increasing;
        }
        
        return true;
    }

    public static char commonVowel(String sentence) {
       
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int[] counts = new int[vowels.length];

        
        sentence = sentence.toLowerCase();

        
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            for (int j = 0; j < vowels.length; j++) {
                if (c == vowels[j]) {
                    counts[j]++;
                    break;
                }
            }
        }    
        int maxIndex = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] >= counts[maxIndex]) {
                maxIndex = i;
            }
        }
        return vowels[maxIndex];
    }
    public static int[][] dataScience(int[][] arrays) {
        int n = arrays.length; 
        int m = arrays[0].length; 
        int[][] result = new int[n][m]; 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    int sum = 0;
                    int count = 0;
                    for (int k = 0; k < n; k++) {
                        if (k != i) {
                            sum += arrays[k][j];
                            count++;
                        }
                    }
                    result[i][j] = Math.round((float) sum / count);
                } else {
                    result[i][j] = arrays[i][j];
                }
            }
        }

        return result;
    }

}

