package Hash;

public class ProductHash {
    public static void main(String[] args) {
        HashTable<String, Product> hashTable = new HashTable<>(10);

        hashTable.isEmpty();

        Product banana = new Product("Banana Dwarf Cavendish(loose)", 5, 45);
        Product orange = new Product("Navel Orange (loose) ", 3, 80);
        Product toothpaste1 = new Product("Colgate toothpaste 180g", 2, 300);
        Product toothpaste2 = new Product("Colgate toothpaste 362g", 2, 300);
        Product toothpaste3 = new Product("Colgate toothpaste 363g", 2, 300);
        Product toothpaste4 = new Product("Colgate toothpaste 364g", 2, 300);
        Product toothpaste5 = new Product("Colgate toothpaste 365g", 2, 300);
        Product toothpaste6 = new Product("Colgate toothpaste 368g", 2, 300);
        Product toothpaste7 = new Product("Colgate toothpaste 367g", 2, 300);
        Product toothpaste8 = new Product("Colgate toothpaste 367g", 2, 300);
        Product toothpaste9 = new Product("Colgate toothpaste 367g", 2, 300);
        Product toothpaste0 = new Product("Colgate toothpaste 367g", 2, 300);
        Product toothpaste11 = new Product("Colgate toothpaste 367g", 2, 300);

        
        hashTable.put("093214",banana); 
        hashTable.put("783921",orange);
        hashTable.put("884510",toothpaste1);
        hashTable.put("874510",toothpaste2);
        hashTable.put("783921",orange);
        hashTable.put("864510",toothpaste3);
        hashTable.put("854510",toothpaste4);
        hashTable.put("844510",toothpaste5);
        hashTable.put("834510",toothpaste5);
        hashTable.put("824510",toothpaste5);
        hashTable.put("814510",toothpaste5);
        hashTable.put("734510",toothpaste5);
        hashTable.put("334510",toothpaste5);
        hashTable.put("144510",toothpaste5);
        hashTable.display();

        hashTable.get("884510").displayInfo();

        hashTable.remove("884510");

        hashTable.isEmpty();
        System.out.println(hashTable.size());
    }
    
}
