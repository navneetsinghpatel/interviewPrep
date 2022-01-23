import java.util.Stack;

public class ValidExpression {
    public static void main(String[] args) {

        if(is_valid("{(1+2)*3}+(4+8)")){
            System.out.println("Valid Expression!!");
        }else {
            System.out.println("Invalid Expression!!");
        }
    }
    // -------- START --------
    public static boolean is_valid(String expression) {
        boolean result = true;
        /*stores digits*/
        Stack st1 = new Stack<>();
        /*stores operators and parentheses*/
        Stack st2 = new Stack<>();
        boolean isTrue = true;
        for (int i = 0; i < expression.length(); i++) {
            char temp = expression.charAt(i);
            /*if the character is a digit, we push it to st1*/
            if (isDigit(temp)) {
                st1.push(temp - '0');
                if(isTrue) {
                    isTrue = false;
                }
                else {
                    return false;
                }
            }
            /*if the character is an operator, we push it to st2*/
            else if (isOperator(temp)) {
                st2.push(temp);
                if(!isTrue) {
                    isTrue = true;
                }
                else {
                    return false;
                }
            }
            else {
                /*if the character is an opening parantheses we push it to st2*/
                if(isBracketOpen(temp)) {
                    st2.push(temp);
                }
                /*If it is a closing bracket*/
                else {
                    boolean flag = true;
                    /*we keep on removing characters until we find the corresponding
                    open bracket or the stack becomes empty*/
                    while (!st2.isEmpty()) {
                        char c = (char) st2.pop();
                        if (c == getCorrespondingChar(temp)) {
                            flag = false;
                            break;
                        }
                        else {
                            if (st1.size() < 2) {
                                return false;
                            }
                            else {
                                st1.pop();
                            }
                        }
                    }
                    if (flag) {
                        return false;
                    }

                }
            }
        }
        while (!st2.isEmpty()) {
            char c = (char) st2.pop();
            if (!isOperator(c)) {
                return false;
            }
            if (st1.size() < 2) {
                return false;
            }
            else {
                st1.pop();
            }
        }
        if (st1.size() > 1 || !st2.isEmpty()) {
            return false;
        }
        return result;
    }
    /*method to get corresponding opening and closing bracket.*/
    public static char getCorrespondingChar(char c) {
        if (c == ')') {
            return '(';
        }
        else if (c == ']') {
            return '[';
        }
        return '{';
    }

    /*checks if the given bracket is open or not.*/
    public static boolean isBracketOpen(char c) {
        if (c == '(' || c == '[' || c == '{') {
            return true;
        }
        return false;
    }

    /*checks if the given character is a digit.*/
    public static boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*') {
            return true;
        }
        return false;
    }
    // -------- END --------

}
