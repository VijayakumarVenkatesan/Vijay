import java.util.Arrays;
import java.util.Scanner;

public class LetterCount {
    public static void count(String s1){
        s1=s1.toLowerCase();
        s1=s1.replace(" ","");
        System.out.println(s1);
        char[] c=s1.toCharArray();
        Arrays.sort(c);
        for(int i=0;i<c.length;i++)
            System.out.print(c[i]);
        System.out.println();
        char curr=c[0];
        int Count=0;
        for(char C:c){
            if(curr==C) {
                ++Count;
                continue;
            }
            switch (curr){
                case 'a','e','i','o','u':
                    System.out.println(curr+" "+Count);
                    curr=C;
                    Count=1;
                    break;
            }
//            System.out.println(curr+" "+Count);
//            curr=C;
//            Count=1;
        }
        switch (curr){
            case 'a','e','i','o','u':
                System.out.println(curr+" "+Count);
                break;
        }
//        System.out.println(curr+" "+Count);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s1;
        System.out.print("Enter the first string:");
        s1=in.nextLine();
        count(s1);
    }
}
