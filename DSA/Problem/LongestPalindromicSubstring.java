package Problem;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter a string:");
        String input=in.nextLine();
        char[] arr=new char[input.length()];
        for(int i=0;i<input.length();i++){
            arr[i]=input.charAt(i);
        }
        int n=input.length(),max=0,start=0,end=0;
        for(int i=0;i<n;i++){
            int j=i;
            ArrayList<Character> c=new ArrayList<>();
            while(j<=n-1){
                for(int k=i;k<=j;k++) c.add(arr[k]);
                ArrayList<Character> rev=new ArrayList<>(c);
                Collections.reverse(rev);
                if(c.size()>1&&c.equals(rev)){
                    max=Math.max(max,c.size());
                    if(max==c.size()){
                        start=i;
                        end=j;
                    }
                }
                c.clear();
                j++;
            }
        }
        String arrStr=new String(arr);
        String res=arrStr.substring(start,end+1);
        System.out.println(arrStr.substring(start,end+1));
    }
}
