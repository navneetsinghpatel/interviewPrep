import java.util.Stack;

public class ValidExpression2 {
    public static void main(String[] args) {

        if(isValidExp("{(1+2)*3}+(4+8)")){
            System.out.println("Valid Expression!!");
        }else {
            System.out.println("Invalid Expression!!");
        }
    }

    public static boolean isValidExp(String exp){
        boolean result = true;

        Stack<Object> Numbers = new Stack<>();
        Stack<Object> Operators = new Stack<>();

        boolean lastInputWasOperator = true;
        for(int i=0; i<exp.length(); i++){

            char currentChar = exp.charAt(i);

            if(isNumber(currentChar)){
                System.out.println("Pushing Number in Stack: "+ currentChar);
                Numbers.push(currentChar - '0');
                System.out.println("Number Stack: "+ Numbers);
                if(lastInputWasOperator){
                    lastInputWasOperator = false;
                }else {
                    return false;
                }

            }else if(isOperator(currentChar)){
                System.out.println("Pushing Operator in Stack: "+ currentChar);
                Operators.push(currentChar);
                System.out.println("Operator Stack: "+ Operators);
                if(!lastInputWasOperator){
                    lastInputWasOperator = true;
                }else {
                    return false;
                }
            }else {
                if(isOpeningBracket(currentChar)){
                    System.out.println("Pushing Opening Bracket in Stack: "+ currentChar);
                    Operators.push(currentChar);
                    System.out.println("Operator Stack: "+ Operators);
                }else {
                    boolean foundOpeningBracket = false;
                    //try and remove all char from Operators until Opening Bracket if found
                    while (!Operators.isEmpty()){
                        System.out.println("Operator Stack: "+ Operators);
                        char popedChar = (char) Operators.pop();
                        System.out.println("Poped Operator Stack: "+popedChar);
                        System.out.println("Operator Stack: "+ Operators);
                        if(popedChar == getOpeningBracket(currentChar)){
                            System.out.println("Found Opening Bracket");
                            foundOpeningBracket = true;
                            break;
                        }else{
                            System.out.println("Didn't Find Opening Bracket so will remove Numbers now as poped Char must be an Operator");
                            //Opening Bracket Not Found so it must be an Operator so removing the number from Numbers
                            //Check if Numbers are less than 2 if yes then operation can't be performed so Expression is not valid
                            if (Numbers.size() < 2) {
                                System.out.println("Less than 2 numbers so Operations can't be performed so Failing!");
                                return false;
                            }
                            else {
                                //There are 2 numbers so removing one and leaving one behind as it will work as an product of the operation
                                System.out.println("removed number from Top: "+Numbers.pop());
                                System.out.println("Numbers Stack: "+ Numbers);
                            }
                        }
                    }
                    if (!foundOpeningBracket){
                        System.out.println("No Opening Bracket so Failing!");
                        return false;
                    }
                }
            }
        }
        while (!Operators.isEmpty()){
            char popedChar = (char) Operators.pop();
            System.out.println("Operator Stack: "+ Operators);
            //checking if Operators Stack has only Operators or not as we have removed all Brackets
            if(!isOperator(popedChar)){
                System.out.println("Found Bracket even though there shouldn't be any");
                return false;
            }
            if(Numbers.size()<2){
                return false;
            }else {
                System.out.println("Poped Number: "+Numbers.pop());
                System.out.println("Number Stack: "+ Numbers);
            }
        }
        if(Numbers.size()>1 || !Operators.isEmpty()){
            return false;
        }
    return result;
    }

    private static char getOpeningBracket(char closingBracket) {
        if(closingBracket == ')')
            return '(';
        else if(closingBracket == ']')
            return '[';
        else
            return '{';
    }

    private static boolean isOpeningBracket(char currentChar) {
        if(currentChar == '(' ||currentChar == '[' || currentChar == '{' ){
            return true;
        }else
        {
            return false;
        }
    }

    private static boolean isOperator(char currentChar) {
        if(currentChar == '+' ||currentChar == '-' || currentChar == '*' ){
            return true;
        }else
        {
            return false;
        }
    }

    private static boolean isNumber(char currentChar) {
        if(currentChar >= '0' && currentChar <= '9'){
            return true;
        }else{
            return false;
        }
    }
}
