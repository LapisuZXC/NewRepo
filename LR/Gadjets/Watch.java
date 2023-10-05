package Gadjets;

public class Watch extends Gadgets {
    private String displayType;
    private String strapMaterial;

    public Watch(String brand, String model, double price, String displayType, String strapMaterial) {
        super(brand, model, price);
        this.displayType = displayType;
        this.strapMaterial = strapMaterial;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getStrapMaterial() {
        return strapMaterial;
    }

    public void setStrapMaterial(String strapMaterial) {
        this.strapMaterial = strapMaterial;
    }

    @Override
    public void displayInfo() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Price: $" + getPrice());
        System.out.println("Display Type: " + getDisplayType());
        System.out.println("Strap Material: " + getStrapMaterial());
    }
}