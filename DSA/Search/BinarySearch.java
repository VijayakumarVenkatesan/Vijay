package Search;

import java.util.Arrays;

public class BinarySearch {
    public static int[] sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i-1,key=arr[i];
            while(j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        return arr;
    }
    public static int binarySearch(int[] arr,int key){
        int[] sorted = Arrays.copyOf(sort(arr),arr.length);
        int start=0,end=arr.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(sorted[mid]==key){
                return mid;
            }
            if(key<sorted[mid]) end=mid-1;
            else start=mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={11,2,34,33,3,44,45};
        int key=45;
        int result=binarySearch(arr,key);
        if(result==-1) System.out.println("The element "+key+" is not found at the array!");
        else System.out.println("The element "+key+" is found at the index of "+result);
    }
}
