public class SubArray {
    public static void main(String[] args) {
        int[] arr={2,6,4,8,3};
        int n=5;
        for(int i=0;i<n;i++){  //1 2 3
            System.out.println();
            int j=i;
            while(j<=n){
                System.out.print("[");
                for(int k=i;k<j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.print("] ");
                j++;
            }
        }
    }
}
