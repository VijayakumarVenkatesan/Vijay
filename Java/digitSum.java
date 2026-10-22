import java.util.Scanner;

public class digitSum {
    public static void main(String [] args){
        Scanner in =new Scanner(System.in);
        System.out.print("Enter a number:");
        int n= in.nextInt();
        int sum=0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        System.out.println("The sum of the given number:"+sum);
    }
}
