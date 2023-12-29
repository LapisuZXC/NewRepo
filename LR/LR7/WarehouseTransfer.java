package LR7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class WarehouseTransfer {
    private static int[] weights = {20, 30, 40, 50, 60, 70, 80, 90, 100};

public static void main(String[] args) {
    List<CompletableFuture<Integer>> futures = new ArrayList<>();
    int totalWeight = 0;
    int batchSize = 150;
    int remainingWeight = 0;

    for (int weight : weights) {
        if (totalWeight + weight <= batchSize) {
            totalWeight += weight;
        } else {
            if (remainingWeight + weight <= batchSize) {
                totalWeight = remainingWeight + weight;
                remainingWeight = 0;
            } else {
                CompletableFuture<Integer> future = moveGoods(totalWeight);
                futures.add(future);
                totalWeight = weight;
                remainingWeight = 0;
            }
        }
        remainingWeight += weight;
    }

    CompletableFuture<Integer> lastFuture = moveGoods(totalWeight);
    futures.add(lastFuture);

    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

    System.out.println("All goods transferred successfully!");
}

    private static CompletableFuture<Integer> moveGoods(int weight) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Moving goods with weight: " + weight);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return weight;
        });
    }
}