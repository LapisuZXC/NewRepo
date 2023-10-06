package Gadjets;

public class Macbook extends Laptop {
    private Double macOS; // приватное поле macOS

    // Конструктор с параметрами brand, model, price, processor, ramSize и macOS
    public Macbook(String brand, String model, double price, String processor, int ramSize, Double macOS) {
        super(brand, model, price,processor,ramSize);  // Вызов конструктора суперкласса 
        this.macOS = macOS; 

    }

    // Геттер для macOS
    public Double getMacOS(){
        return macOS;
    }

    // Cеттер для macOS
    public void setMacOS(Double macOS){
        this.macOS = macOS;
    }

    // Переопределение метода displayInfo() из суперкласса 
    @Override
    public void displayInfo() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Price: $" + getPrice());
        System.out.println("Processor: " + getProcessor());
        System.out.println("RAM Size: " + getRamSize() + "GB");
        System.out.println("macOS version:" + getMacOS());
    }
}
