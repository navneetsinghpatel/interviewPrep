import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.System.exit;
import static java.lang.System.in;

public class LongestSubStringWithDistinctChar2 {

    public static void main(String[] args) {

        String input = "aaabbbcccccbskksskaaabskcbmmmmm";
        int len = input.length();
        Map<Character, Integer> map = new HashMap<>();
        int longest = 1, startIndex =0;
        for (int i = 0; i < len; i++) {
            char currentChar = input.charAt(i);
            map.put(currentChar, map.getOrDefault(currentChar, 0)+1);
            if(map.size()<=2){
                continue;
            }else {
                int tempLen = geCurrentLength(map);
                if(longest<tempLen){
                    longest= tempLen-1;
                }
                char charToRemove = input.charAt(startIndex);
                while (map.get(charToRemove)!=0){
                    map.put(charToRemove,map.getOrDefault(charToRemove, 0)-1);
                    startIndex++;
                    if(map.get(charToRemove)==0){
                        map.remove(charToRemove);
                        break;
                    }
                }

            }
        }
        System.out.println("Longest: "+ input.substring(startIndex, startIndex+longest+1));

    }

    private static int geCurrentLength(Map<Character, Integer> map) {
        int length =0;
        for(char c: map.keySet()){
         length +=map.get(c);
        }
        return length;
    }


}
