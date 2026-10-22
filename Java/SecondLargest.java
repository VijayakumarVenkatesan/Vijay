public class SecondLargest {
    public static void main(String[] args) {
        int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
        int[] arr={12,32,45,6,778,56};
        for(int i=0;i< arr.length;i++){
            if(arr[i]>first){
                second=first;
                first=arr[i];
            }else if(arr[i]>second){
                second=arr[i];
            }
        }
        if(second==Integer.MIN_VALUE)
            System.out.println("No second largest!");
        else
            System.out.println("The second largest element: "+second);
    }
}
