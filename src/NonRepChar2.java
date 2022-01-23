
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NonRepChar2 {

    public static void main(String[] args) {

       Scanner input = new Scanner(System.in);
        System.out.print("Enter the Word: ");
        String word = input.nextLine();
        System.out.println("The Word: '"+ word+"'");

        char result = getFirstNonRepeatingCharacter(word);
        if(result == ' ') {
            System.out.println("Didn't find any non-repeating character");
        }else {
            System.out.println("The First Non Repeating Character is : "+ result);
        }
    }

    private static char getFirstNonRepeatingCharacter(String word) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int count =0;
        for (char c: map.keySet()) {
            count++;
            if(map.get(c)==1){
                System.out.println("Count: "+count);
                return c;
            }
        }
        return ' ';
    }

}
