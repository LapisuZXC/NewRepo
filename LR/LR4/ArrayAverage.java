package LR4;

import java.lang.reflect.Array;
import java.util.InputMismatchException;


public class ArrayAverage {
    public static void main(String[] args) {
        Array inputArray1 = {1,2,3,4,5};
        Array inputArray2 = {};
        Array inputArray3 = {"sadasd","asdda","sd"};
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
    public static double arrayAverage(int[] inputArray) throws arrayAverageExсeption{
        if (inputArray.length == 0){
            throw new arrayAverageExсeption("Array is empty!");
        }
        

        
        int sum = 0;
        for (int i : inputArray){
            sum+= i;
        }
        return sum/inputArray.length;
    }
}
