import java.util.*;

import static java.lang.System.exit;
import static java.lang.System.in;

public class ShortestSubStringWithAllLetters {

    public static void main(String[] navneet){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Word: ");
        String input = scanner.nextLine();
        System.out.println("The Word: '"+ input+"'");
        input = input.trim();
        System.out.println("The Word after trim: '"+ input+"'");

        if(!input.isEmpty()) {
        int inputLen = input.length();

        if(inputLen==1){
            System.out.println("Only 1 Char in Input: "+input);
            exit(0);
        }
        int uniqueSize = getDistinctCharactersInGivenString(input);
        if(uniqueSize==1){
            System.out.println("Only One Unique Char: "+input.charAt(0));
            exit(0);
        }
        int shortest = Integer.MAX_VALUE;
        Map<Character, Integer> uniqueMap = new HashMap<>();
        int i, startIndex=0;
        for(i=0; i<inputLen; i++){
            char currentChar = input.charAt(i);
            uniqueMap.put(currentChar, uniqueMap.getOrDefault(currentChar, 0)+1);

            if(uniqueMap.size()==uniqueSize){
                while (uniqueMap.size()==uniqueSize && uniqueMap.get(input.charAt(startIndex))>1){
                    uniqueMap.put(input.charAt(startIndex),uniqueMap.get(input.charAt(startIndex))-1);
                    startIndex++;
                }
                if(shortest>(i-startIndex+1)){
                    shortest = (i-startIndex+1);
                    if(shortest==uniqueSize){
                        break;
                    }
                }
            }
        }
        System.out.println("Shortest SubString : "+ input.substring(startIndex, startIndex+shortest));
        }else {
            System.out.println("Incorrect Input!!!");
        }
    }
    public static int getDistinctCharactersInGivenString(String temp)
    {
        Set<Character> unique = new LinkedHashSet<>();
        for (int i=0; i<temp.length();i++) {
            unique.add(temp.charAt(i));
        }
        return unique.size();
    }
}
