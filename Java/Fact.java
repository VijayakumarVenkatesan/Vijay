import java.util.Scanner;
public class Fact {
    public static int fact(int n){
        if(n==1) return 1;
        return n*fact(n-1);
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(fact(n));
    }
}