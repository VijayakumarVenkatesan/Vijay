import java.util.*;
class Solution {
    public int countValidSelections(int[] nums) {
        boolean[] curr=new boolean[nums.length];
        int start=0,end=nums.length-1,result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                start=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]!=0){
                end=i;
                break;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) curr[i]=true;
        }
        for(int i=0;i<nums.length;i++){
            if(curr[i]){
                System.out.println(curr[i]);
                int[] num1=Arrays.copyOf(nums,nums.length);
                int[] num2=Arrays.copyOf(nums,nums.length);
                System.out.println("right");
                if(simulate(num1,i,true)){
                    result++;
                }
                System.out.println("left");
                if(simulate(num2,i,false)){
                    result++;
                }
            }
        }
        return result;
    }
    public static boolean simulate(int[] num,int pos,boolean direction){
        boolean zero=true;
        for(int i=0;i<num.length;i++){
            if(num[i]!=0){
                zero=false;
                break;
            }
        }
        if(zero){
            return true;
        }
        if(direction) pos++;
        else pos--;
        if(pos==num.length||pos==-1) return false;
        if((pos==0&&num[pos]==0)||(pos==num.length-1&&num[pos]==0)) return false;
        if(num[pos]==0) return simulate(num,pos,direction);
        num[pos]=num[pos]-1;
        for(int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();
        return simulate(num,pos,!direction);
    }
}