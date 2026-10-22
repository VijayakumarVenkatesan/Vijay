package Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={12,23,4,5,11};
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    arr[j]=arr[j]+arr[j+1];
                    arr[j+1]=arr[j]-arr[j+1];
                    arr[j]=arr[j]-arr[j+1];
                }
            }
        }
        System.out.println("The sorted array: "+ Arrays.toString(arr));
    }
}
