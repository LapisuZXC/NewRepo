import java.util.InputMismatchException;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)") );
        System.out.println(generateNonconsecutive("6 – 18 / (-1 + 4)") ); 
    }
    public static double div(String str){
        double result = 0.0;
        int slashIndex = str.indexOf("/");
        if (slashIndex != -1 ){
            try {
                if (str.split("/").length == 2){
                        double[] numbersToDivide = {Double.parseDouble(str.split("/")[0]),Double.parseDouble(str.split("/")[1])};
                        result = numbersToDivide[0] / numbersToDivide[1];
                }
                else throw new InputMismatchException("Неверные данные");
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        } 
        return result;
    }
    public static double mul(String str){
        double result = 0.0;
        int starIndex = str.indexOf("*");
        if (starIndex != -1){
            try {
                if(str.split("\\*").length == 2){
                double[] numbersToMul = {Double.parseDouble(str.split("\\*")[0]),Double.parseDouble(str.split("\\*")[1])};
                result = numbersToMul[0] * numbersToMul[1];
                }
                else throw new InputMismatchException("Неверные данные");
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return result; 
    }
    public static double add(String str){
        double result = 0.0;
        int plusIndex = str.indexOf("+");
        if (plusIndex != -1){
            try {
                if(str.split("\\+").length == 2){
                double[] numbersToAdd = {Double.parseDouble(str.split("\\+")[0]),Double.parseDouble(str.split("\\+")[1])};
                result = numbersToAdd[0] + numbersToAdd[1];
                }
                else throw new InputMismatchException("Неверные данные");
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
    public static double sub(String str){
        double result = 0.0;
        boolean isNegative = false;
        if (str.startsWith("-")){
            str = str.substring(1);
            isNegative = true;
        }
        int minusIndex = str.indexOf("-");
        if (minusIndex != -1){
            try {
                if(str.split("\\-").length == 2){
                double[] numbersToSub = {Double.parseDouble(str.split("\\-")[0]),Double.parseDouble(str.split("\\-")[1])};
                if (isNegative == true) {result = -numbersToSub[0] - numbersToSub[1];}
                else{ result = numbersToSub[0] - numbersToSub[1];}
                }
                else throw new InputMismatchException("Неверные данные");
            }
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }



    public static double generateNonconsecutive(String eq) {
        // Remove all spaces from the equation
        eq = eq.replaceAll("\\s", "");

        // Create a stack to keep track of the operands and operators
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < eq.length(); i++) {
            char c = eq.charAt(i);
            if (Character.isDigit(c)) {
                // If the character is a digit, parse the entire number and push it to the operands stack
                StringBuilder numBuilder = new StringBuilder();
                while (i < eq.length() && (Character.isDigit(eq.charAt(i)) || eq.charAt(i) == '.')) {
                    numBuilder.append(eq.charAt(i));
                    i++;
                }
                i--; // Move back one position to account for the increment in the loop
                operands.push(Double.parseDouble(numBuilder.toString()));
            } else if (c == '(') {
                // If the character is an opening parenthesis, push it to the operators stack
                operators.push(c);
            } else if (c == ')') {
                // If the character is a closing parenthesis, perform operations until the corresponding opening parenthesis is found
                while (!operators.isEmpty() && operators.peek() != '(') {
                    performOperation(operands, operators);
                }
                operators.pop(); // Discard the opening parenthesis
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // If the character is an operator, perform operations until the stack is empty or the top operator has lower precedence
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    performOperation(operands, operators);
                }
                operators.push(c);
            }
        }

        // Perform remaining operations
        while (!operators.isEmpty()) {
            performOperation(operands, operators);
        }

        // The result is the top element of the operands stack
        return operands.pop();
    }

    // Helper method to check precedence of operators
    private static boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false; // op1 has higher precedence
        }
        return true; // op1 has lower or equal precedence
    }

    // Helper method to perform an operation
    private static void performOperation(Stack<Double> operands, Stack<Character> operators) {
        char operator = operators.pop();
        double operand2 = operands.pop();
        double operand1 = operands.pop();
        double result = 0.0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }
        operands.push(result);
    }


}
