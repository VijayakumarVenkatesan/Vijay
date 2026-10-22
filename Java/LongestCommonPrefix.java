public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int len=strs.length;
        int min=Integer.MAX_VALUE;
        boolean flag=true;
        String res="";
        for(int i=0;i<len;i++){
            min=Math.min(min,strs[i].length());
        }
        for(int i=0;i<min;i++){
            for(int j=0;j<len-1;j++){
                if(strs[j].charAt(i)==strs[j+1].charAt(i)) flag=true;
                else {
                    flag=false;
                    break;
                }
            }
            if(flag) res+=strs[0].charAt(i);
            else break;
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strs={"flower","flag","flow"};
        String result=longestCommonPrefix(strs);
        System.out.println("The longest common prefix in the string array is \""+result+"\"");
    }
}
