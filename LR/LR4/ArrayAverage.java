package LR4;

public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        //int[] arr2 = {1,2,3,4,"dddd"};
        arrayAverage(arr1);
        //arrayAverage(arr2);
    }
    public static void arrayAverage(int[] arr)  {
        int sum = 0;
        int count = 0;
        try {
            for (int j : arr) {
                sum += j;
                count++;
            }

            double average = (double) sum / count;
            System.out.println("Среднее арифметическое элементов массива: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: элемент массива не является числом");
        }
    }
}

