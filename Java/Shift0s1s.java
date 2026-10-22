public class Shift0s1s {
    public static void main(String[] args) {
        int arr[]={1,1,1,0,0};
        int n=5;
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n;j++){
                if(arr[i]>arr[j]){
                    int t=arr[j];
                    arr[j]=arr[i];
                    arr[i]=t;
                }

            }
        }
        for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
    }
}
