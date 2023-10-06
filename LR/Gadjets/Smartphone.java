package Gadjets;

public class Smartphone extends Gadgets {
    private String operatingSystem; //Приватное поле operatingSystem
    private int storageCapacity; //Приватное поле storageCapacity

    public Smartphone(String brand, String model, double price, String operatingSystem, int storageCapacity) {
        super(brand, model, price); // Вызов конструктора суперкласса 
        this.operatingSystem = operatingSystem;
        this.storageCapacity = storageCapacity;
    }

    //Геттер operatingSystem
    public String getOperatingSystem() {
        return operatingSystem;
    }

    //Cеттер operatingSystem
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    //Геттер storageCapacity
    public int getStorageCapacity() {
        return storageCapacity;
    }

    //Cеттер storageCapacity
    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    // Переопределение метода displayInfo() из суперкласса 
    @Override
    public void displayInfo() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Price: $" + getPrice());
        System.out.println("Operating System: " + getOperatingSystem());
        System.out.println("Storage Capacity: " + getStorageCapacity() + "GB");
    }
}