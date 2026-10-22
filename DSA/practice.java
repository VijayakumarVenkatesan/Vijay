import Sort.InsertionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class practice {
    public static int fibbo(int n){
        if(n<=2) return n;
        return fibbo(n-1)+fibbo(n-2);
    }
    public static boolean happy(int n){
        int sum;
        while(n!=1&&n!=4) {
            sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
            System.out.println(n);
        }
        return n==1;
    }
    public static void prime(int n1,int n2){
        boolean flag;
        for(int i=n1;i<=n2;i++){
            if(i%2!=0){
                if(i%3!=0){
                    flag=true;
                    for(int j=4;j<Math.sqrt(i);j++){
                        if(i%j==0){
                            flag=false;
                        }
                    }
                    if(flag) System.out.println(i);
                }
            }
        }
    }
    public static void subArrayTarget(int[] arr,int target){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length+1;j++){
                int sum=0;
                for(int k=i;k<j;k++){
                    sum+=arr[k];
                }
                if(sum==target){
                    System.out.print("Found:");
                    for(int k=i;k<j;k++){
                        System.out.print(arr[k]);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a={1,2,2,1};
        subArrayTarget(a,4);
        int[] b={2,2};
        List<Integer> result=new ArrayList<>();
        for(int i:a){
            for(int j:b){
                if(i==j) {
                    result.add(a[i]);
                    break;
                }
            }
        }
        System.out.println(result);
    }
}