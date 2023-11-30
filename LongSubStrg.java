import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class LongSubStrg{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String alpha = input.nextLine();
        int maxLen = 0;
        Map<Character, Integer> keep = new HashMap<>();
        for(int i=0; i<alpha.length(); i++){
            char ch = alpha.charAt(i);
            if(keep.containsKey(ch)){
                i = keep.get(ch);
                keep.clear();
            }
            else{
                keep.put(ch, i);
                maxLen = Math.max(maxLen, keep.size());
            }
        }
        System.out.println(maxLen);
        input.close();
    }
}
