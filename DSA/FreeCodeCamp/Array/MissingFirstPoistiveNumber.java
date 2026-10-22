package FreeCodeCamp.Array;

import java.util.*;

public class MissingFirstPoistiveNumber {
    public static void main(String[] args) {
        int[] arr={-18,2,3,332,1,4,-1};
        int result=1;
        Set<Integer> set=new HashSet<>();
        for(int n:arr){
            if(n>0){
                set.add(n);
            }
        }
        while(set.contains(result)){
            result++;
        }
        System.out.println(result);
    }
}