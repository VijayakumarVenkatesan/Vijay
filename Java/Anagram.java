import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static boolean anagram(String s1,String s2){
        boolean result;
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        char[] a=s1.toCharArray();
        char[] b=s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if(Arrays.equals(a,b))
            result=true;
        else
            result=false;
        return result;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s1,s2;
        System.out.print("Enter the first string:");
        s1=in.nextLine();
        System.out.print("Enter the second string:");
        s2=in.nextLine();
        if(anagram(s1,s2))
            System.out.println("The "+s1+" and "+s2+" are Anagram.");
        else
            System.out.println("The "+s1+" and "+s2+" are not Anagram.");
    }
}
