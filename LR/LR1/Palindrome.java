
public class Palindrome{
    
    public static void main(String[] args) {
        for (int i=0; i<args.length;i++){
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }

    public static String reverse(String str){
        String result = "";
        for (int i = (str.length()-1); i >= 0; i--)
        {
            result += String.valueOf(str.charAt(i));
        }
        return result;
    }
    public static boolean isPalindrome(String arg){
        for (int i = 0;i<arg.length(); i++){
            if (!(String.valueOf(arg.charAt(i)).equalsIgnoreCase(String.valueOf((reverse(arg).charAt((i)))))) ){
                return false;
            }
        }
        return true;
    }
}

