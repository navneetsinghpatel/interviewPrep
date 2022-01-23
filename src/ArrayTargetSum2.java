import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayTargetSum2 {


    public static void main(String[] args) {

        int[] inputArray = {1, -2, 1, 0, 5};
        Arrays.sort(inputArray);
        System.out.println("Input Array: " + Arrays.toString(inputArray));
        int targetSum = 3;

        int[] found = getTargetSumIndices(inputArray, targetSum);
        if(found.length>0) {
            System.out.println("Found indices: " + Arrays.toString(found));
        }else {
            System.out.println("Indices not found!");
        }
    }

    private static int[] getTargetSumIndices(int[] inputArray, int targetSum) {
        int start = 0, end = inputArray.length-1;
        while (start<end){
            if(inputArray[start]+inputArray[end] == targetSum){
                return new int[]{start, end};
            }else if (inputArray[start]+inputArray[end] > targetSum){
                end--;
            }else {
                start++;
            }
        }
        return new int[]{};
    }
}
