import java.util.Scanner;
public class Test {
    static Scanner in=new Scanner(System.in);
    public static void main(String [] args){
        int n;
        System.out.println("Enter a number");
        n=in.nextInt();
        int last =n%10;
        while(n>9){
            n=n/10;
        }
        int sum=n+last;
        System.out.println(n+"+"+last+"="+sum);
    }
}
