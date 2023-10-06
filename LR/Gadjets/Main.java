package Gadjets;

public class Main {
    public static void main(String[] args) {
        Watch watch = new Watch("Apple", "Watch Series 7", 399.99, "OLED", "Stainless Steel");
        Smartphone smartphone = new Smartphone("Samsung", "Galaxy S21", 999.99, "Android", 128);
        Laptop laptop = new Laptop("Dell", "XPS 13", 1299.99, "Intel Core i7", 16);
        laptop.setBrand("");
        Macbook macbook = new Macbook("Apple", "pro", 999.99, "Apple M1 Pro", 16, 16.7);

        macbook.setPrice(800.0);

        watch.displayInfo();
        System.out.println();
        smartphone.displayInfo();
        System.out.println();
        laptop.displayInfo();
        System.out.println();
        macbook.displayInfo();
        
    }
}
