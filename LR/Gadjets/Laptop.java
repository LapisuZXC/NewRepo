package Gadjets;

public class Laptop extends Gadgets {
    private String processor; // Приватное поле processor
    private int ramSize; // Приватное поле ramSize

    // Конструктор с параметрами brand, model, price, processor и ramSize
    public Laptop(String brand, String model, double price, String processor, int ramSize) {
        super(brand, model, price); // Вызов конструктора суперкласса 
        this.processor = processor;
        this.ramSize = ramSize;
    }

    // Геттер для поля processor
    public String getProcessor() {
        return processor;
    }

    // Сеттер для поля processor
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    // Геттер для поля ramSize
    public int getRamSize() {
        return ramSize;
    }

    // Сеттер для поля ramSize
    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    // Переопределение метода displayInfo() из суперкласса 
    @Override
    public void displayInfo() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Price: $" + getPrice());
        System.out.println("Processor: " + getProcessor());
        System.out.println("RAM Size: " + getRamSize() + "GB");
    }
}
