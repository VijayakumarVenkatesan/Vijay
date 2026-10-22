public class CountAndSay {
    public static String countAndSay(int n) {
        if(n==1) return "1";
        String  result="1";
        for(int i=2;i<=n;i++){
            int count=1;
            StringBuilder sb=new StringBuilder();
            for(int j=1;j<result.length();j++){
                if(result.charAt(j)==result.charAt(j-1)) count++;
                else{
                    sb.append(count).append(result.charAt(j-1));
                    count=1;
                }
            }
            sb.append(count).append(result.charAt(result.length() - 1));
            result = sb.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
