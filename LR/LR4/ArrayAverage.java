package LR4;

import java.lang.reflect.Array;
import java.util.InputMismatchException;


public class ArrayAverage<T> {
    
    public static void main(String[] args) {
        int[] inputArray1 = {1,2,3,4,5};
        String[] inputArray2 = {};
        String[] inputArray3 = {"sadasd","asdda","sd"};
        try {
            arrayAverage(inputArray1);
            arrayAverage(inputArray2);
            arrayAverage(inputArray3);
        } catch (InputMismatchException e) {
            System.out.println("Input does not match data type");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Input out of index");
        }
    }
    private double arrayAverage(T[] inputArray) throws arrayAverageExсeption{
        if (inputArray.length == 0){
            throw new arrayAverageExсeption("Array is empty!");
        }
        
        

        
        int sum = 0;
        try{
        for (T i : inputArray){
            sum+= Integer.valueOf(i);
        }}
        return sum/inputArray.length;
    }
}
