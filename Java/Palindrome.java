import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.Scanner;

public class Palindrome {
    public static void main(String [] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a number:");
        int n=in.nextInt();
        int rev=0,original=n;
        while(n>0){
            rev=rev*10+n%10;
            n/=10;
        }
        System.out.println("The given number:"+original+"\nThe reverse number:"+rev);
        if(original==rev){
            System.out.println("The given number is palindrome");
        }
        else{
            System.out.println("The given number is not a palindrome");
        }
    }
}
