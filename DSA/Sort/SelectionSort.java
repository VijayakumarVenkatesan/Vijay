package Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={12,23,4,5,11};
        for(int i=0;i<arr.length-2;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            if(min!=i){
                arr[i]=arr[i]+arr[min];
                arr[min]=arr[i]-arr[min];
                arr[i]=arr[i]-arr[min];
            }
        }
        System.out.println("The sorted array: "+ Arrays.toString(arr));
    }
}
