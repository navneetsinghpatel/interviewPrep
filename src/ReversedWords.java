public class ReversedWords {

    public static void main(String[] args){

        String input = " I will   do it.  ";
        int length = input.length();
        System.out.println("Input String: "+ input);
        System.out.println("Input String Length: "+ input.length());
        StringBuilder output= new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for(int i= length-1; i>-1; i--){
            if(input.charAt(i) ==' ') {
                if(temp.length() > 0){
                    output.append(reverseWord(temp.toString()));
                    temp = new StringBuilder();
                }
                output.append(" ");
            }else {
                temp.append(input.charAt(i));
            }
        }
        System.out.println("Output String: "+ output+ " And Length: "+ output.length());
    }

    public static String reverseWord(String word){
        StringBuilder Result = new StringBuilder();
        for(int i=word.length()-1;i>-1;i--){
            Result.append(word.charAt(i));
        }
        return Result.toString();
    }

}
