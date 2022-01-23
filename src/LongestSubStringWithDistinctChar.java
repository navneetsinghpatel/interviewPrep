import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.System.exit;

public class LongestSubStringWithDistinctChar {

    public static void main(String[] args) {

        String input = "aaabbbcccccbskksskaaabskcbmmmmm";
        int len = input.length();
        Set<Character> visitedSet = new HashSet<>();
        String longest = "";
        String temp="";
        for (int i=0; i<len;i++){
            for (int j= i; j<len; j++){
                char cc= input.charAt(j);
                visitedSet.add(cc);
                if(visitedSet.size()<=2){
                    temp += input.charAt(j);
                }else {
                    System.out.println("Temp : "+temp);
                    if(longest.length()<temp.length()) {
                        longest = temp;
                    }
                    System.out.println("Temp Longest: "+longest);
                    temp ="";
                    visitedSet = new HashSet<>();
                    System.out.println("Breaking");
                    break;
                }
                System.out.println("j = "+j);
                if(j==len-1){
                    if(longest.length()<temp.length()) {
                        longest = temp;
                    }
                    System.out.println("Temp at the End Index: "+temp);
                    System.out.println("Longest at the End Index: "+longest);
                    exit(0);
                }
            }
        }
        if(longest.length()<temp.length()) {
            longest = temp;
        }
        System.out.println("Longest : "+longest);
    }
}
