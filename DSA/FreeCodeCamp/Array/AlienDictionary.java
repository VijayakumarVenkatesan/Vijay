package FreeCodeCamp.Array;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String s="vijaybcdefghklmnopqrstuwxz";
        String[] words={"vijay","vijayakumar","siva","arun","suriya"};
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        for(int i=0;i<words.length-1;i++){
            for(int j=0;j<words[i].length();j++){
                if(j>=words[i+1].length()){
                    System.out.println("False");
                    return;
                }
                if(words[i].charAt(j)!=words[i+1].charAt(j)){
                    int curr=map.get(words[i].charAt(j));
                    int next=map.get(words[i+1].charAt(j));
                    if(curr>next){
                        System.out.println("False");
                        return;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        System.out.println("True");
    }
}
