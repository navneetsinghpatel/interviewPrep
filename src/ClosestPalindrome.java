import java.util.Scanner;

public class ClosestPalindrome {

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number:");
        int number = scanner.nextInt();
        for(int i=number-1,j=number+1;i>=0;i--,j++){
            if(isPalindrome(i)){
               if(isPalindrome(j)){
                   System.out.println("Both "+i+" and "+j+ " are Closest Palindrome");
               }else {
                   System.out.println(i+" is the Closest Palindrome");
               }
               break;
            }else if(isPalindrome(j)){
                System.out.println(j+" is the Closest Palindrome");
                break;
            }
        }

    }

    static boolean isPalindrome(int number){
        String num = Integer.toString(number);
        int left = 0, right=num.length()-1;
        while (left<right){
            if(num.charAt(left)!=num.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    static boolean isPalindromeUsingMod(int number){
        boolean is = false;
        if(number>=0 && number<10){
            return true;
        }
        int sum=0, remainder;
        int temp = number;
        while(number>0){
            remainder=number%10;
            sum=(sum*10)+remainder;
            number=number/10;
        }
        if(temp==sum) {
            is = true;
        }
        return is;
    }
}
