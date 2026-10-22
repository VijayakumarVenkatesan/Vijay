public class MissingNumbers {
    public static void main(String[] args) {
        int arr[]={1,5,6};
        int n=6;
        boolean present[]=new boolean[n+1];
        for(int num:arr)
            if(num>=1&&num<=n) present[num]=true;
        for(int i=1;i<=n;i++)
            if(!present[i]) System.out.print(i+" ");
    }
}