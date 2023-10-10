package Gadjets;

public class Watch extends Gadgets {
    private static int watchCount = 0; //статический счётчик
    private String displayType; // приватное поле displayType
    private String strapMaterial; // приватное поле strapMaterial
    Watch(){displayType = "null";strapMaterial = "null";}
    public Watch(String brand, String model, double price, String displayType, String strapMaterial) {
        super(brand,model, price);
        this.displayType = displayType;
        this.strapMaterial = strapMaterial;
        watchCount++; // увеличение значения счетчика при создании объекта
    }

    public static int getWatchCount() {
        return watchCount;
    }

    //Геттер displayType
    public String getDisplayType() {
        return displayType;
    }

    //Сеттер displayType
    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    //Геттер strapMateria
    public String getStrapMaterial() {
        return strapMaterial;
    }

    //Сеттер strapMateria
    public void setStrapMaterial(String strapMaterial) {
        this.strapMaterial = strapMaterial;
    }

    // Переопределение метода displayInfo() из суперкласса 
    @Override
    public void displayInfo() {
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Price: $" + getPrice());
        System.out.println("Display Type: " + getDisplayType());
        System.out.println("Strap Material: " + getStrapMaterial());
        System.out.println("Wathces:" + getWatchCount());
    }
}