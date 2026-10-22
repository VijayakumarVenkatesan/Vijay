package Problem;

import java.util.*;

public class PowerGridMaintanance {
    public static int[] processQueries(int c, int[][] connections, int[][] queries) {
        int[] result=new int[queries.length];
        List<Integer> res=new ArrayList<>();
        Set<Integer> online=new HashSet<>();
        List<TreeSet<Integer>> con=new ArrayList<>();
        for(int i=0;i<=c;i++){
            con.add(new TreeSet<>());
        }
        for(int i=1;i<=c;i++){
            online.add(i);
        }
        for(int i=0;i<connections.length;i++){
            con.get(connections[i][0]).add(connections[i][1]);
            con.get(connections[i][1]).add(connections[i][0]);
        }
        for(int i=0;i<queries.length;i++){
            switch(queries[i][0]){
                case 1:
                    res.add(maintainance(queries[i][1],online,con));
                    break;
                case 2:
                    offline(queries[i][1],online,con);
                    break;
            }
        }
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        result=Arrays.copyOf(result,res.size());
        return result;
    }
    public static int maintainance(int station,Set<Integer> online,List<TreeSet<Integer>> con){
        if(online.contains(station)){
            return station;
        }
        else if(!con.get(station).isEmpty()){
            return con.get(station).first();
        }
        return -1;
    }
    public static void offline(int station,Set<Integer> online,List<TreeSet<Integer>> con){
        online.remove(Integer.valueOf(station));
        for(TreeSet<Integer> set: con){
            if(set.contains(station)){
                set.remove(station);
            }
        }
    }
}
