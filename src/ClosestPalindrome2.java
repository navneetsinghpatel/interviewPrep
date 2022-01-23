import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

import static java.lang.System.exit;

public class ClosestPalindrome2 {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int input = scanner.nextInt();
        if(input==0){
            System.out.println(1);
            exit(0);
        }else if(input<0){
            System.out.println("Invalid Input");
            exit(0);
        }
        int i=input-1, j= input+1;
        while (i>=0){
            if(isPalindrome(i)){
                if(isPalindrome(j)){
                    System.out.println(i+" and "+j);
                }else {
                    System.out.println(i);
                }
                break;
            }else if(isPalindrome(j)){
                System.out.println(j);
                break;
            }
            i--; j++;
        }
    }

    public static boolean isPalindrome(int number){
        String num = Integer.toString(number);
        int left = 0, right = num.length()-1;
        while (left < right){
            if(num.charAt(left) != num.charAt(right)){
                return false;
            }
            left++; right--;
        }
        return true;
    }

    public static boolean isPalindrome2(int number){
        int remainder = 0;
        int sum = 0;
        int temp = number;
        while (temp>0){
            remainder = temp%10;
            sum = (sum * 10) + remainder;
            temp = temp/10;
        }
        if(sum==number){
            return true;
        }
        return false;
    }
}
