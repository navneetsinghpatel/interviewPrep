import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.exit;
import static java.lang.System.in;

public class ShortestSubStringWithAllLetters2 {

    public static void main(String[] navneet){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Word: ");
        String input = scanner.nextLine();
        System.out.println("The Word: '"+ input+"'");
        if(input!=null) {
            if (input.length() == 1) {
                System.out.println("Only 1 Char in Input: " + input);
                exit(0);
            }
            int uniqueSize = getDistinctCharactersInGivenString(input);
            System.out.println("Unique Size= " + uniqueSize);
            if (uniqueSize == 1) {
                System.out.println("Only One Unique Char: " + input.charAt(0));
                exit(0);
            }
            String shortest = input;
            String temp = "";
            int uniqueCharsInTempSubString = 0;
            boolean foundShortest = false;
            for (int i = 0; i < input.length(); i++) {
                for (int j = i; j < input.length(); j++) {
                    temp = temp + input.charAt(j);
                    if (temp.length() >= uniqueSize) {
                        System.out.println("Temp before checking distinct: " + temp);
                        uniqueCharsInTempSubString = getDistinctCharactersInGivenString(temp);
                    }
                    if (uniqueCharsInTempSubString == uniqueSize) {
                        if (shortest.length() >= temp.length()) {
                            System.out.println("Temp with distinct chars: " + temp);
                            shortest = temp;
                            if (shortest.length() == uniqueSize) {
                                foundShortest = true;
                                System.out.println("Found Shortest: " + shortest);
                            }
                        }
                        uniqueCharsInTempSubString = 0;
                        temp = "";
                        break;
                    }
                }
                if (foundShortest) {
                    break;
                }
            }
            System.out.println("Shortest SubString: " + shortest);
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
