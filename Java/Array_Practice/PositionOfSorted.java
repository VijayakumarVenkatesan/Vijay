package Array_Practice;

import java.util.Arrays;
import java.util.HashMap;

public class PositionOfSorted {
    public static void main(String[] args) {
        HashMap<Integer,Integer> position=new HashMap<>();
        int[] arr={30,20,10,10};
        // 10 10 20 30     3 2 1 1
        int[] sort=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            sort[i]=arr[i];
        }
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int key=sort[i];
            while(j>=0&&key<sort[j]){
                sort[j+1]=sort[j];
                j--;
            }
            sort[j+1]=key;
        }
        int pos=1;
        System.out.println(Arrays.toString(sort));
        for(int item:sort){
            if(!position.containsKey(item)){
                position.put(item,pos);
                pos++;
            }
        }
        int[] result=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            result[i]=position.get(arr[i]);
        }
        System.out.println(Arrays.toString(result));
    }
}
