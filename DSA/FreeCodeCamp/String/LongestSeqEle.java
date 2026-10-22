package FreeCodeCamp.String;

import java.util.*;

public class LongestSeqEle {
    public static void main(String[] args) {
        int[] arr={1,2,4,5,3,454,232,6};
        int curr=1,max=0;
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==1){
                curr++;
                max=Math.max(max,curr);
            }
            else{
                curr=1;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(max);
    }
}
