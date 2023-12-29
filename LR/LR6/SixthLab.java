package LR6;

public class SixthLab {
    public static void main(String[] args) {
        TopWords.topWords("LR/LR6/text.txt");
        System.out.println();
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println();
        SalesTracker track = new SalesTracker();
        track.addSale("tooth paste", 322);
        track.addSale("Lays s crabom", 512);
        track.addSale("Coca cola espuma", 117);
        track.addSale("Freddy Fuzzbear Toy", 9999);
        track.printSales();
        System.out.println();

        System.out.println(track.getTotalSales());
        System.out.println(track.getMostPopularProduct());
    }
}
