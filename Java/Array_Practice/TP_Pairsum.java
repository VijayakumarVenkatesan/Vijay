package Array_Practice;

public class TP_Pairsum {
    static void sort(int[] arr){
        for(int i=1;i< arr.length;i++){
            int j=i-1;
            int key=arr[i];
            while(j>=0&&key<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    static void pairSum(int[] arr,int target){
        sort(arr);
        int start=0,end=arr.length-1;
        while(start<end){
            int sum=arr[start]+arr[end];
            if(sum==target){
                System.out.println("Pair: "+arr[start]+" and "+arr[end]);
                start++;
                end--;
            }
            else if(sum>target) end--;
            else start++;
        }
    }
    public static void main(String[] args) {
        int[] arr={12,13,14,11,15};
        pairSum(arr,26);
    }
}
