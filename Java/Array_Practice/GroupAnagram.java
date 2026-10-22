package Array_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs={"bat","eat","tea","tan","ate","nat"};
        List<List<String>> result=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        int pos=0;
        for(int i=0;i<strs.length;i++){
            char[] ch=strs[i].toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            if(!map.containsKey(key)) map.put(key,pos++);
        }
        for(int i=0;i<map.size();i++) result.add(new ArrayList<>());
        for(int i=0;i< strs.length;i++){
            char[] ch=strs[i].toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            result.get(map.get(key)).add(strs[i]);
        }
        System.out.println(result);
    }
}
