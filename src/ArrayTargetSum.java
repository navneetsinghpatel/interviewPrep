import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayTargetSum {


    public static void main(String[] args) {

      int[] inputArray =  {1, 2, 5, 4, 6};
      int targetSum = 6;

        Map<Integer, int[]> indices = getTargetSum(inputArray, targetSum);
      if(indices.isEmpty()){
          System.out.println("Could Not Found the target Sum");
      }else {

          for (int i: indices.keySet()) {
              System.out.println("Found the indices with target sum: "+ Arrays.toString(indices.get(i)));
          }
      }
    }

    private static Map<Integer, int[]> getTargetSum(int[] inputArray, int targetSum) {
        int tempSum = 0;
        int index = 1;
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0; i<inputArray.length-1; i++){
            for(int j=i+1; j<inputArray.length; j++){
                tempSum = inputArray[i]+inputArray[j];
                if(tempSum==targetSum){
                    System.out.println("Values : "+ inputArray[i] + " and "+ inputArray[j]);
                    map.put(index, new int[]{i, j});
                    index++;
                }
            }
        }
    return map;
    }


}
