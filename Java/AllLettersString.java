import java.util.*;

public class AllLettersString {
    public static void check(String s1){
        Set<Character> unique=new LinkedHashSet<>();
        s1=s1.toLowerCase();
        for(char c:s1.toCharArray()){
            if(c>='a'&&c<='z'){
                unique.add(c);
            }
        }
        if(unique.size()==26)
            System.out.print("The string does contains all letters");
        else
            System.out.print("The string does not contains all letters");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s1 = in.nextLine();
        check(s1);
    }
}
