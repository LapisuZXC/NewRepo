package LR7;

public class MultiThreadedMax{
    private static int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 100, 11, 12},
            {13, 14, 15, 16}
    };
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Thread[] threads = new Thread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int row = i;
            threads[i] = new Thread(() -> {
                
                synchronized (MultiThreadedMax.class) {
                    for (int num : matrix[row]) {
                        if (num > max) {
                            max = num;
                        }
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Max: " + max);
    }
}
