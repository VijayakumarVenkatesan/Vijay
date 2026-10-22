import java.util.LinkedHashMap;
import java.util.Map;

public class SecondMostOccuredLetter {
    public static void main(String[] args) {
        String s="Hello world",org;
        org=s;
        s=s.replace(" ","");
        s=s.toLowerCase();
        Map<Character,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        char[] key=new char[s.length()];
        int pos=0;
        for(char c:map.keySet()){
            key[pos++]=c;
        }
        pos=0;
        int[] freq=new int[s.length()];
        for(int n:map.values()){
            freq[pos++]=n;
        }
        int first=0,second=0;
        for(int i=1;i<freq.length;i++) {
            if (freq[i] > freq[second]) {
                if (freq[i] > freq[first]) {
                    second = first;
                    first = i;
                } else
                    second = i;
            }
        }
        System.out.println("Second most occurred character in \""+org+"\" :"+key[second]);
    }
}