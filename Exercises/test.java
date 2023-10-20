public class test {
    public static void main(String[] args) {
        Double var = 3.5;
        System.out.println(var.intValue());
        System.out.println(test(3));
        System.out.println();
    }
    public static String test(int arg){
        arg *= 2;
        int open = arg/2;
        int close = arg/2 + 1;
        StringBuilder instance = new StringBuilder();
        for (int i = 0; i < open; i++){
            instance.append("(");
        }
        for(int j = close; j < open+close; j++){
            instance.append(")");
        }
        return instance.toString();
    }
    

}
