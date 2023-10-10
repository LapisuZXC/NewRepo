package LR4;




public class ArrayAverage {
    public static void main(String[] args) {
        
    }
    public static double arrayAverage(int[] inputArray) throws arrayAverageExсeption{
        if (inputArray.length == 0){
            throw new arrayAverageExсeption("Array is empty!");
        }
        else if (){

        }
        int sum = 0;
        for (int i : inputArray){
            sum+= i;
        }
        return sum/inputArray.length;
    }
}
