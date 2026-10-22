package FreeCodeCamp.String.SlidingWindow;

public class CheckS1PermutationInS2 {
    public static Boolean checkInclusion(String s1,String s2){
        int[] s1Freq=new int[26];
        int[] s2Freq=new int[26];
        for(int i=0;i<s1.length();i++){
            s1Freq[s1.charAt(i)-'a']++;
            s2Freq[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length()-s1.length();i++){
            if(compare(s1Freq,s2Freq)) return true;
            s2Freq[s2.charAt(i+s1.length())-'a']++;
            s2Freq[s2.charAt(i)-'a']--;
        }
        if(compare(s1Freq,s2Freq)) return true;
        return false;
    }
    public static boolean compare(int[] s1Freq,int[] s2Freq){
        for(int i=0;i<26;i++){
            if(s1Freq[i]!=s2Freq[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1="abc",s2="sdjfncab";
        System.out.println(checkInclusion(s1,s2));
    }
}
