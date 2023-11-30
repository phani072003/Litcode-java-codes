import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Cookies {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int TargetSweetness = input.nextInt();
        input.nextLine();
        String candies = input.nextLine();
        input.close();
        String[] arr = candies.split(" ");
        int[] array = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            array[i] = Integer.parseInt(arr[i]);
        }
        List<Integer> arrayList = new ArrayList<>();
        for (Integer element : array) {
            arrayList.add(element);
        }
        int count = 0;
        Collections.sort(arrayList);
        while(arrayList.get(0)<TargetSweetness){
            arrayList.add(arrayList.get(0) + arrayList.get(1)*2);
            arrayList.remove(0);
            arrayList.remove(0);
            Collections.sort(arrayList);
            count++;
        }
        System.out.println(count);
    }
}
