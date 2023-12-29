package LR6;

import java.util.HashMap;
import java.util.Map;


public class SalesTracker {
    private Map<String, Integer> sales;

    public SalesTracker() {
        sales = new HashMap<>();
    }

    public void addSale(String product, int quantity) {
        sales.put(product, sales.getOrDefault(product, 0) + quantity);
    }

    public void printSales() {
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public int getTotalSales() {
        int total = 0;
        for (int quantity : sales.values()) {
            total += quantity;
        }
        return total;
    }

    public String getMostPopularProduct() {
        String mostPopularProduct = null;
        int maxQuantity = 0;
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                mostPopularProduct = entry.getKey();
                maxQuantity = entry.getValue();
            }
        }
        return mostPopularProduct;
    }
}