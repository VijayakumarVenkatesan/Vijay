package Array_Practice;

public class AllSubArrays {
    public static void longSubArraySum(int[] arr,int target){
        int start=-1,end=-1;
        for(int i=0;i<arr.length;i++){
            int j=i+1,sum=0,max=0;
            while(j<arr.length){
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                if(sum==target){
                    int len=j-i;
                    max=Math.max(max,len);
                    if(len==max){
                        start=i;
                        end=j;
                    }
                }
                j++;
            }
        }
        if(start>-1&&end>-1){
            System.out.print("The longest sub array is: [");
            for(int i=start;i<=end;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.print("]");
        }
        else{
            System.out.println("The sum not match with any sub array");
        }
    }
    public static void main(String[] args) {
        int[] arr={2,6,2,8};
        for(int i=0;i<arr.length;i++){
            int j=i;
            while(j<arr.length){
                System.out.print("[");
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.print("] ");
                j++;
            }
            System.out.println();
        }
        longSubArraySum(arr,8);
    }
}
