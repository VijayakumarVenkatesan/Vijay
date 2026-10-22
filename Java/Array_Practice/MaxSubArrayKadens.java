package Array_Practice;

public class MaxSubArrayKadens{
    public static int maxSubArray(int[] arr){
        int max=arr[0];
        int currentMax=arr[0];
        for (int i=1;i<arr.length;i++){
            currentMax=Math.max(arr[i], currentMax + arr[i]);
            max=Math.max(max, currentMax);
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum sub array sum: " + maxSubArray(arr));
    }
}