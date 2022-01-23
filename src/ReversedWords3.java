import java.util.Scanner;
import java.util.Stack;

public class ReversedWords3 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String: ");
        String input = scanner.nextLine();
        if(input.isEmpty()){
            System.out.println("Invalid Input!!");
        }else{
            System.out.println("Input String: '"+ input+"' and length: "+input.length());
            Stack<String> stack = new Stack<>();
            String[] splitWords = input.split(" ");
            for (String s: splitWords) {
                if (!s.isEmpty()){
                    stack.push(s.trim());
                }
            }
            System.out.println("Stack: "+stack);
            StringBuilder output = new StringBuilder();
            int length = input.length();
            for(int i =length-1; i>=0; i--){
                if(input.charAt(i)==' '){
                    output.append(input.charAt(i));
                }else {
                    System.out.println("length of popped item: "+stack.peek().length());
                    i= i- stack.peek().length()+1;
                    output.append(stack.pop());
                }
            }
            System.out.println("Correct Output String: '"+ output+"' and length: "+output.length());

        }
    }
}
