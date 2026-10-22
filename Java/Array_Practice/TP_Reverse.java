package Array_Practice;

import java.util.Arrays;

public class TP_Reverse {
    static void reverse(int[] arr){
        System.out.println(Arrays.toString(arr));
        int start=0,end=arr.length-1;
        while(start<end){
            arr[start]=arr[start]+arr[end];
            arr[end]=arr[start]-arr[end];
            arr[start]=arr[start]-arr[end];
            start++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr={15,14,13,12,11};
        reverse(arr);
    }
}
