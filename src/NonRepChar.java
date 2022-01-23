import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepChar {

    public static void main(String[] args) {

        String input = "teetotaller";
        int[] count = new int[26];
        for(int i=0; i<input.length();i++){
           count[input.charAt(i)-'a']++;
        }
        for (int i=0; i<input.length();i++) {
            if(count[input.charAt(i)-'a']==1){
                System.out.println("Index ="+ i);
                System.out.println("Letter ="+ input.charAt(i));
                break;
            }
        }
    }

}
