package Array_Practice;

import java.util.Arrays;

public class FirstLastOccurrence {
    public static int firstOccurUnsorted(int[] arr,int k){
        int pos=-1;
        for(int i=0;i<arr.length;i++){
            if(k==arr[i]){
                return i;
            }
        }
        return pos;
    }
    public static int lastOccurUnsorted(int[] arr,int k){
        int pos=-1;
        for(int i=0;i<arr.length;i++){
            if(k==arr[i]){
                pos=i;
            }
        }
        return pos;
    }
    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int key=arr[i];
            while(j>=0&&key<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    public static int firstOccurSorted(int[] arr,int k){
        int pos=-1;
        int start=0,last=arr.length-1;
        while(start<=last){
            int mid=(start+last)/2;
            if(arr[mid]==k){
                pos=mid;
                last=mid-1;
                continue;
            }
            if(arr[mid]<k) start=mid+1;
            else last=mid-1;
        }
        return pos;
    }
    public static int lastOccurSorted(int[] arr,int k){
        int pos=-1;
        int start=0,last=arr.length-1;
        while(start<=last){
            int mid=(start+last)/2;
            if(arr[mid]==k){
                pos=mid;
                start=mid+1;
                continue;
            }
            if(arr[mid]<k) start=mid+1;
            else last=mid-1;
        }
        return pos;
    }
    public static void main(String[] args) {
        int[] arr={12,34,12,23,45,67,32,45,33,12};
        int k=12;
        System.out.println("In unsorted array:");
        System.out.println(Arrays.toString(arr));
        System.out.println("First Occurrence of "+k+" at index "+firstOccurUnsorted(arr,k));
        System.out.println("Last Occurrence of "+k+" at index "+lastOccurUnsorted(arr,k));
        sort(arr);
        System.out.println("In sorted array:");
        System.out.println(Arrays.toString(arr));
        System.out.println("First Occurrence of "+k+" at index "+firstOccurSorted(arr,k));
        System.out.println("Last Occurrence of "+k+" at index "+lastOccurSorted(arr,k));
    }
}
