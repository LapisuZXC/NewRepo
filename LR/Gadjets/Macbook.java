package Gadjets;

public class Macbook extends Laptop {
    private Double macOS; // приватное поле macOS
    Macbook(){macOS = 0.0;}
    // Конструктор с параметрами brand, model, price, processor, ramSize и macOS
    public Macbook(String brand, String model, double price, String processor, int ramSize, Double macOS) {
        super(brand, model, price,processor,ramSize);  // Вызов конструктора суперкласса 
        this.macOS = macOS; 

    }
    public void explode(){
        System.out.println("macbook just exploded");
    }

    public void explode(int input){
        for (int i=0; i<input; i++){
            System.out.println("macbook just exploded");
        }
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
