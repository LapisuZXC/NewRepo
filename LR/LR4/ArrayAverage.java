package LR4;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayAverage{
    public static void main(String[] args) {
        int sum = 0;
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[5];
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print("Введите значение для " + i + " элемента массива: ");
                arr[i] = scan.nextInt();
            }
            scan.close();
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            
            double average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: неверные данные в массиве");
        }
    }
    
}
