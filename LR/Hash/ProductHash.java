package Hash;

public class ProductHash {
    public static void main(String[] args) {
        HashTable<String, Product> hashTable = new HashTable<>(10);

        hashTable.isEmpty();

        Product banana = new Product("Banana Dwarf Cavendish(loose)", 5, 45);
        Product orange = new Product("Navel Orange (loose) ", 3, 80);
        Product toothpaste = new Product("Colgate toothpaste 180g", 2, 300);
        
        hashTable.put("093214",banana); 
        hashTable.put("783921",orange);
        hashTable.put("884510",toothpaste);

        hashTable.get("884510").displayInfo();

        hashTable.remove("884510");

        hashTable.isEmpty();
    }
    
}
