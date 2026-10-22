package Array_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Prefix_Suffix_Sum {
    static int[] prefix(int[] arr){
        int[] prefix=new int[arr.length];
        int sum=0;
        for(int i=0;i< arr.length;i++){
            sum+=arr[i];
            prefix[i]=sum;
        }
        return prefix;
    }
    static int[] suffix(int[] arr){
        int[] suffix=new int[arr.length];
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[arr.length-1-i];
            suffix[i]=sum;
        }
        return suffix;
    }
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60};
        System.out.println("Prefix sum: "+Arrays.toString(prefix(arr)));
        System.out.println("Suffix sum: "+Arrays.toString(suffix(arr)));
    }
}
