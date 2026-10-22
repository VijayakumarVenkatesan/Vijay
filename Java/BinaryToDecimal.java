import java.util.Scanner;

public class BinaryToDecimal{
    public static void main(String [] args){
        int bi;
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a binary number:");
        bi=in.nextInt();
        int ori=bi;
        double ans=0;
        int power=0;
        int last;
        while(bi>0){
            last=bi%10;
            ans=ans+last*Math.pow(2,power);
            bi/=10;
            power+=1;
        }
        System.out.println(ori+"-->"+ans);
    }
}
