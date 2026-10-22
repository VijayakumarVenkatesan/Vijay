import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] arr,int target){
        int closestSum=arr[0]+arr[1]+arr[2];
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            int left=i+1,right=arr.length-1;
            while (left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if(target==sum) return sum;
                if(Math.abs(sum-target)<Math.abs(sum-closestSum)) closestSum=sum;
                if(sum<target) left++;
                else right--;
            }
        }
        return closestSum;
    }
    public static void main(String[] args) {
        int[] arr={1,-3,2,4,-2};
        int target=5;
        System.out.println("The closest sum of "+target+" is "+threeSumClosest(arr,target));
    }
}
