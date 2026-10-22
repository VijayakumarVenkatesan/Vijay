import java.util.Scanner;
public class Xylem {
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a number:");
        int n= in.nextInt();
        int last=n%10,sum=0;
        n/=10;
        while(n>9){
            sum=sum+n%10;
            n/=10;
        }
        n+=last;
        System.out.println(n+" "+sum);
        if(n==sum){
            System.out.println("The given number is Xylem");
        }
        else{
            System.out.println("The given number is Folem");
        }
    }
}
