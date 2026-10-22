package Search;

public class LinearSearch {
    public static int linearSearch(int[] arr,int key){
        int index=-1;
        for(int i=0;i<arr.length;i++){
            if(key==arr[i]) return i;
        }
        return index;
    }
    public static void main(String[] args) {
        int[] arr={12,34,2,3,34};
        int key=2;
        int result=linearSearch(arr,key);
        if(result==-1) System.out.println("The element "+key+" is not found in the array!");
        else System.out.println("The element "+key+" is found at the array in the  position: "+result);
    }
}
