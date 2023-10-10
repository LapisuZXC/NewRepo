import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.println(dataScience(inputArray9));
        System.out.println(dataScience(inputArray10));
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
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(i));
            if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                result.append("Double");}
            else{
                result.append(input.charAt(i));
            }
        }
        return result.toString();}
    
    public static boolean doesBlockFit(int a,int b,int c,int w,int h){
        int area = w*h;
        if (a*b <= area || a*c<=area || b*c <= area){
            return true;
    }
        return false;
        
}
    public static boolean numCheck(int num){
        String numStr = String.valueOf(num);
        int digitSquaredSum = 0;
        for (int i =0; i< numStr.length()-1 ;i++){
            digitSquaredSum += Integer.valueOf(numStr.charAt(i));
        }
        if((num % 2 == 0 && digitSquaredSum % 2==0)||(num%2!=0 && digitSquaredSum%2!=0)){
            return true;
        }else {
    return false;}}
    public static int countRoots(int[] inputArray){
        int d = (inputArray[1] * inputArray[1])- (4 * inputArray[0] * inputArray[2]);
        if (d>0){
            return 2;
        }
        else if (d==0){
            return 1;
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
        // Создаем массив с гласными буквами
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int[] counts = new int[vowels.length];

        // Приводим предложение к нижнему регистру для удобства сравнения
        sentence = sentence.toLowerCase();

        // Подсчитываем количество каждой гласной в предложении
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            for (int j = 0; j < vowels.length; j++) {
                if (c == vowels[j]) {
                    counts[j]++;
                    break;
                }
            }
        }

        // Находим индекс гласной с наибольшим количеством встреч
        int maxIndex = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > counts[maxIndex]) {
                maxIndex = i;
            }
        }

        // Возвращаем гласную с наибольшим количеством встреч
        return vowels[maxIndex];
    }
    public static String dataScience(int[][] arr) {
        int n = arr.length;  // number of arrays
        int m = arr[0].length;  // length of arrays
        String[][] result = new String[n]z
        // Calculate the arithmetic mean for each column, except the last one
        int[] columnSums = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != n - 1) {  // exclude the last array
                    columnSums[j] += arr[i][j];
                }
            }
        }

        int[] averages = new int[m];  // arithmetic means
        for (int j = 0; j < m; j++) {
            averages[j] = columnSums[j] / (n - 1);
        }

        // Replace the n-th element of the n-th array with the corresponding arithmetic mean
        for (int j = 0; j < m; j++) {
            arr[n - 1][j] = Arrays.toString(averages[j]);
        }
        
        return Arrays.toString(arr);
    }

}

