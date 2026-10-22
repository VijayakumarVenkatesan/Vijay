package Sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={12,23,4,5,11};
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        System.out.println("The sorted array: "+ Arrays.toString(arr));
    }
}
