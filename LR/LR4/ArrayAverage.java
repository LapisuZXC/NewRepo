package LR4;

import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ArrayAverage {
    
    public static void main(String[] args) {
        Scanner sr = new Scanner("");
        int s = Integer.valueOf(sr.nextLine());
        int[] inputArray = new int[s];
        for (int i =0;i<s;i++){
            inputArray[i] = Integer.valueOf(sr.nextLine());
        }
        

        try {
            arrayAverage(inputArray);
        } catch (arrayAverageExсeption e) {
            System.out.println("Input does not match data type");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Input out of index");
        }
    }
    private static Double arrayAverage(int[] inputArray) throws arrayAverageExсeption{
        if (inputArray.length == 0){
            throw new arrayAverageExсeption("Array is empty!");
        }
        
        

        
        
    
        Double sum = 0.0;
        for (int i : inputArray){
            sum += i;
        
        return sum/inputArray.length;
    }
    }
}   
