package String;

import java.util.ArrayList;
import java.util.List;

/*
Input: Hi@fl$mvf^mfm)odk
Output: Hi)fl^mvf$mfm@odk
*/

public class ReverseSpecialChar {
    public static void main(String[] args) {
        String s="Hi@fl$mvf^mfm)odk";
        char[] ch=s.toCharArray();
        List<Integer> index=new ArrayList<>();
        for(int i=0;i<ch.length;i++){
            if(!Character.isAlphabetic(ch[i])){
                index.add(i);
            }
        }
        int left=0,right=index.size()-1;
        while(left<right){
            char temp=ch[index.get(left)];
            ch[index.get(left)]=ch[index.get(right)];
            ch[index.get(right)]=temp;
            left++;
            right--;
        }
        String result="";
        for(char c: ch) result=result+c;
        System.out.println(s+"\n"+result);
    }
}
