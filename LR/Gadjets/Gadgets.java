package Gadjets;

public abstract class Gadgets { 
    private String brand; // Приватное поле brand
    private String model; // Приватное поле model
    private double price; // Приватное поле price
    Gadgets() {brand = "not defined" ; model = "not defined"; price = 0;}
    // Конструктор с параметрами brand, model и price
    public Gadgets(String brand, String model, double price){
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Геттер для поля brand
    public String getBrand() {
        return brand;
    }

    // Сеттер для поля brand
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    // Геттер для поля model
    public String getModel() {
        return model;
    }

    // Сеттер для поля model
    public void setModel(String model) {
        this.model = model;
    }

    // Геттер для поля price
    public double getPrice() {
        return price;
    }

    // Сеттер для поля price
    public void setPrice(double price) {
        this.price = price;
    }

    // Абстрактный метод displayInfo, который должен быть реализован в подклассах
    public abstract void displayInfo();
}