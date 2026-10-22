import java.util.Scanner;

public class Fibbo {
    public static void fibbo(int count,int n1,int n2){
        if(count!=1){
            if(n1==0){
                System.out.print(n1+" "+n2+" ");
            }
            int n3=n1+n2;
            System.out.print(n3+" ");
            count-=1;
            fibbo(count,n2,n3);
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a numbe:");
        int count=in.nextInt();
        System.out.println();
        fibbo(count,0,1);
    }
}
