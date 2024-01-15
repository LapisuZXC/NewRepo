package LR8;
public class Test{
    public static void main(String[] args) {
        DataManager manager = new DataManager();

        NameSort processor1 = new NameSort();
        ValueSort processor2 = new ValueSort();
        MoreThanTen processor3 = new MoreThanTen();

        manager.registerDataProcessor(processor1);
        manager.registerDataProcessor(processor2);
        manager.registerDataProcessor(processor3);

        manager.loadData("C:\\Users\\Lapisu\\Desktop\\NewRepo\\LR\\LR8\\source.txt");
        manager.processData();
        manager.saveData("newData.txt");
    }
}
