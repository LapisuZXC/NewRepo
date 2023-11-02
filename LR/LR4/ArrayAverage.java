package LR4;

import java.lang.reflect.Array;
import java.util.InputMismatchException;


public class ArrayAverage<T> {
    public static void main(String[] args) throws arrayAverageExсeption{
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        try {
            // Обработка массива
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            double average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            
            System.out.println("Ошибка! Выход за границы массива.");
        } catch (NumberFormatException e) {
           
            System.out.println("Ошибка! Элемент массива не является числом.");
        }
    }
}
