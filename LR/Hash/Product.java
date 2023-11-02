package Hash;

public class Product{
    private String name;
    private int cost;
    private int amount;

    public Product(String name, int cost, int amount){
        this.name = name;
        this.cost = cost;
        this.amount = amount;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }
    
    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public void displayInfo(){
        System.out.println("Product's name: " + getName());
        
        System.out.println("Product's cost: " + getCost());
        
        System.out.println("Amount: " + getAmount());
        
    }
}