import java.util.HashMap;
import java.util.Scanner;
public class ContiguousSubarray{
    public static int findMaxLength(int binary[]){
       HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
       int maxLength = 0;
       int sum = 0;
       sumIndexMap.put(0, -1);
       for(int i = 0; i<binary.length; i++){
           sum += (binary[i] == 0) ? -1 : 1;
           if(sumIndexMap.containsKey(sum)){
               maxLength = Math.max(maxLength, i-sumIndexMap.get(sum));
           }
           else sumIndexMap.put(sum, i);
       }
       return maxLength;
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String[] inputStringArray = input.nextLine().split(" ");
        int[] nums = new int[inputStringArray.length];
        for(int i=0; i<inputStringArray.length; i++){
            nums[i] = Integer.parseInt(inputStringArray[i]);
        }
        System.out.println(findMaxLength(nums));
        input.close();
    }
}