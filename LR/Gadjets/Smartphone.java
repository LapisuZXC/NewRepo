package Gadjets;

public class Smartphone extends Gadgets {
    private String operatingSystem;
    private int storageCapacity;

    public Smartphone(String brand, String model, double price, String operatingSystem, int storageCapacity) {
        super(brand, model, price);
        this.operatingSystem = operatingSystem;
        this.storageCapacity = storageCapacity;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Price: $" + getPrice());
        System.out.println("Operating System: " + getOperatingSystem());
        System.out.println("Storage Capacity: " + getStorageCapacity() + "GB");
    }
}