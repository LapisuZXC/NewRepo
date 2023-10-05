package Gadjets;

public class Laptop extends Gadgets {
    private String processor;
    private int ramSize;

    public Laptop(String brand, String model, double price, String processor, int ramSize) {
        super(brand, model, price);
        this.processor = processor;
        this.ramSize = ramSize;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    @Override
    public void displayInfo() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Price: $" + getPrice());
        System.out.println("Processor: " + getProcessor());
        System.out.println("RAM Size: " + getRamSize() + "GB");
    }
}
