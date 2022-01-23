import java.util.Scanner;
import java.util.Stack;

public class ValidExpression3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Expression: ");
        String expression = input.next();

        if(isValidExpression(expression)){
            System.out.println("Valid Expression");
        }else {
            System.out.println("Invalid Expression");
        }
    }

    private static boolean isValidExpression(String expression) {

        Stack<Object> numberStack = new Stack<>();
        Stack<Object> operatorStack = new Stack<>();
        boolean wasLastCharOperator = true;
        for(int i=0; i<expression.length(); i++){
            char currentChar = expression.charAt(i);
            if(isNumber(currentChar)){
                numberStack.push(currentChar);
                if(wasLastCharOperator) {
                    wasLastCharOperator = false;
                }else
                    return false;
            }else if(isOperator(currentChar)){
                operatorStack.push(currentChar);
                if(!wasLastCharOperator) {
                    wasLastCharOperator = true;
                }else
                    return false;
            }else {
                if(isOpeningBracket(currentChar)){
                    operatorStack.push(currentChar);
                }else {
                    boolean foundClosingBracket = false;
                    while (!operatorStack.isEmpty()){
                        char poppedChar = (char) operatorStack.pop();
                        if(poppedChar == getOpeningBracket(currentChar)){
                            foundClosingBracket = true;
                            break;
                        }else {
                            if(numberStack.size()<2){
                                return false;
                            }else {
                                numberStack.pop();
                            }
                        }
                    }
                    if (!foundClosingBracket){
                        return false;
                    }
                }
            }
        }
        while (!operatorStack.isEmpty()){
            char poppedChar = (char)operatorStack.pop();
            if(!isOperator(poppedChar)){
                return false;
            }
            if(numberStack.size()<2){
                return false;
            }else {
                numberStack.pop();
            }
        }
        if(numberStack.size()>1 || !operatorStack.isEmpty()){
            return false;
        }
      return true;
    }

    private static char getOpeningBracket(char currentChar) {
        if(currentChar == ')')
            return '(';
        else if(currentChar == ']')
            return '[';
        else
            return '{';
    }

    private static boolean isOpeningBracket(char currentChar) {
        if(currentChar == '(' || currentChar == '[' || currentChar == '{' )
            return true;
        else
            return false;
    }

    private static boolean isOperator(char currentChar) {
        if(currentChar == '+' || currentChar == '-' || currentChar == '*' )
            return true;
        else
            return false;
    }

    private static boolean isNumber(char currentChar) {
        if(currentChar >= '0' && currentChar <= '9')
            return true;
        else
            return false;
    }
}
