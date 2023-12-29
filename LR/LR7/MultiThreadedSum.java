package LR7;
import java.util.Arrays;

public class MultiThreadedSum {
    private static int[] array = {2, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int sum = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            int partialSum = Arrays.stream(array, 0, array.length / 2).sum();
            synchronized (MultiThreadedSum.class) {
                sum += partialSum;
            }
        });

        Thread thread2 = new Thread(() -> {
            int partialSum = Arrays.stream(array, array.length / 2, array.length).sum();
            synchronized (MultiThreadedSum.class) {
                sum += partialSum;
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sum: " + sum);
    }
}
/*

https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Thread.html

When a Java Virtual Machine starts up, there is usually a single non-daemon thread
 (which typically calls the method named main of some designated class). 
 The Java Virtual Machine continues to execute threads until either of the following occurs:
    The exit method of class Runtime has been called and the security manager has permitted the exit operation to take place.

    All threads that are not daemon threads have died, either by returning from the call to the run method 
    or by throwing an exception that propagates beyond the run method.
 */