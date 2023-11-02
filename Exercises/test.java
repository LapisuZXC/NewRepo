public class test {
    public static void main(String[] args) {
        Double var = 3.5;
        String str = "H3";
        int il = str.charAt(1);
        System.out.println(var.intValue());
        System.out.println(test(3));
        System.out.println(il);
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
