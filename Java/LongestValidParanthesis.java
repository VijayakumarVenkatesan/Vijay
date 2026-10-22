import java.util.Stack;

public class LongestValidParanthesis {
    public static boolean valid(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push('(');
            else if(!stack.isEmpty()) stack.pop();
            else return false;
        }
        if(stack.isEmpty()) return true;
        return false;
    }
    public static int longestValidParentheses(String s) {
        if(s==null||s.length()==1) return 0;
        int length=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==')') continue;
            for(int j=i+2;j<=s.length();j=j+2){
                if(valid(s.substring(i,j))) length=Math.max(length,j-i);
            }
        }
        return length;
    }
    public static void main(String[] args) {
        String s=")(()())";
        //System.out.println(longestValidParentheses(s));
        int left=0,right=0,length=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') left++;
            else right++;
            if(left==right) length=Math.max(length,right*2);
            else if(right>left) left=right=0;
        }
        System.out.println(length);
    }
}
