public class Chumakov_1 {
    
    public static void main(String[] args)
    // у меня prettier code formatter поэтому вот да
    {
        System.out.println(convert(3));
        System.out.println(convert(5));
        System.out.println(convert(8));
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println(conteiner(3,4,2));
        System.out.println(conteiner(5,0,2));
        System.out.println(conteiner(4,1,4));
        System.out.println(triangaleType(5,5,5));// в методичке тут ошибк
        System.out.println(triangaleType(5,4,5));// в методичке тут ошибк
        System.out.println(triangaleType(3,4,5));
        System.out.println(triangaleType(5,1,1));
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println(howManyItems(22,1.4,2));
        System.out.println(howManyItems(45,1.8,1.9));
        System.out.println(howManyItems(100,2,2));
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7)); // в методичке тут ошибк
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }

    // Выполняя эти задания я не использовал конструкцию try-catch 
    // Вывод ошибок оформил через обычное сообщение, так как не понял как райзить ошибки 
    // хендл некрорректного импута очень простой и не подробный

    public static double convert(double input_in_gallon){
         return input_in_gallon * 3.78541;
    }

    public static int fitCalc(int time, int intensity){
        return time*intensity;
    }

    public static int conteiner(int bags, int boxes, int barrels){
        return bags * 20 + boxes * 50 + barrels * 100;

    }

    public static String triangaleType(int Side_a,int Side_b,int Side_c){
        if ((Side_a > 0) && (Side_b > 0) && (Side_c > 0)){
            if ((Side_a + Side_b > Side_c && Side_b + Side_c > Side_a && Side_a + Side_c > Side_b)){ // проверка соотношения сторон
                if (Side_a == Side_b && Side_b == Side_c){
                    return "Equilateral"; // равносторонний
                }
                else if (Side_a == Side_b || Side_b == Side_c || Side_a == Side_c){
                    return "Isosceles"; // равнобедренный
                }
                else{
                    return "Scalene"; // неравносторонний треугольник
                }
            }
            else {
                return "Not a triangle";
            }
        }
        else
        {
            return "negative length?????";
        }
        
    }

    public static int ternaryEvaluation(int x,int y){
        return ((x > y)?x:y);
    }

    public static int howManyItems(double Material, double Width, double Height) {
            
            return (int)(Material/(Width*Height)*2);
    }

    public static int factorial(int a){
        int result = 1;
        for(short i = 1;i < a+1; i++){ 
            
            result = (int)(result*i);

        }
        return result;
    }

    public static int  gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    
    public static double ticketSaler(int amount, int price) {
        return 0.72 * price * amount;
    }
    
    public static int tables(int students_amount, int tables_amount){
            int Sits_avalable = (tables_amount * 2);
            if (Sits_avalable < students_amount){
                if (students_amount % 2 == 0)
                { // чётность проверяю
                    return (int)(students_amount - Sits_avalable)/2;
                }
                else
                {
                    return (int)((students_amount - Sits_avalable)/2) + 1;
                }
            }
            else return 0;
        }
    
}