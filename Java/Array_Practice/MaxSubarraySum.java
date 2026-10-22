package Array_Practice;

public class MaxSubarraySum {
    static int maxSum(int[] arr,int size){
        int maxSum,windowSum=0;
        for(int i=0;i<size;i++){
            windowSum+=arr[i];
        }
        maxSum=windowSum;
        for(int i=size;i<arr.length;i++){
            windowSum+=arr[i]-arr[i-size];
            maxSum=Math.max(windowSum,maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr={11,12,13,14,15};
        int size=2;
        System.out.println("The max sum of subarray size of "+size+" is "+maxSum(arr,size));
    }
}
