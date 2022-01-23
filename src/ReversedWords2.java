import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

import java.util.Scanner;

public class ReversedWords2 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String: ");
        String input = scanner.nextLine();
        if(input.isEmpty()){
            System.out.println("Invalid Input!!");
        }else{
            System.out.println("Input String: '"+ input+"' and length: "+input.length());
            StringBuilder output = new StringBuilder();
            int length = input.length();
            StringBuilder temp = new StringBuilder();
            for(int i =length-1; i>=0; i--){
                if(input.charAt(i) == ' '){
                    if(temp.length()>0){
                        System.out.println("Temp:'"+temp+"'");
                        output.append(reverseWord(temp));
                        temp.delete(0, temp.length());
                    }
                    output.append(input.charAt(i));
                }else {
                    temp.append(input.charAt(i));
                }
            }
            System.out.println("Correct Output String: '"+ output+"' and length: "+output.length());

        }

    }

    private static StringBuilder reverseWord(StringBuilder temp) {
        /*StringBuilder reversed = new StringBuilder();
        for (int j= temp.length()-1; j>=0; j--){
            reversed.append(temp.charAt(j));
        }
        return reversed;*/
        return new StringBuilder(temp.reverse());
    }

}
