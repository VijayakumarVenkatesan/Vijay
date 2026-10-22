import java.util.*;

public class GroupAnagrams {
    public static void groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        int pos=0;
        for(int i=0;i<strs.length;i++){
            char[] ch=strs[i].toCharArray();
            Arrays.sort(ch);
            String sorted=new String(ch);
            if(!map.containsKey(sorted)) map.put(sorted,pos++);
        }
        for(int i=0;i<map.size();i++)
            result.add(new ArrayList<>());
        for(int i=0;i<strs.length;i++){
            char[] ch=strs[i].toCharArray();
            Arrays.sort(ch);
            String sorted=new String(ch);
            int index=map.get(sorted);
            result.get(index).add(strs[i]);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("\t\t\tGroup Anagrams");
        Scanner in=new Scanner(System.in);
        System.out.print("Enter number of strings you will enter: ");
        int n=in.nextInt();
        System.out.println("Enter strings: ");
        System.out.println();
        String[] strs=new String[n];
        for(int i=0;i<n;i++){
            strs[i]=in.nextLine();
        }
        groupAnagrams(strs);
    }
}
