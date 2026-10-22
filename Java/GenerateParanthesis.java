import java.util.ArrayList;
import java.util.Scanner;

public class GenerateParanthesis {
    public static void Generate(ArrayList<String> result,String current,int open,int close,int n){
        if(current.length()==n*2){
            result.add(current);
            return;
        }
        if(open<n) Generate(result,current+"(",open+1,close,n);
        if(close<open) Generate(result,current+")",open,close+1,n);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n;
        System.out.print("Enter a number: ");
        n=in.nextInt();
        ArrayList<String> result=new ArrayList<>();
        Generate(result,"",0,0,n);
        for(String s:result) System.out.println(s);
    }
}
