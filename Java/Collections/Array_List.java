package Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Array_List {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(20);
        arr.add(100);
        arr.add(101);
        int sum=arr.stream().mapToInt(Integer::intValue).sum();
        long count=arr.stream().count();
        long evenCount=arr.stream().filter(n->n%2==0).count();
        List<Integer> arr1=arr.stream().map(n->n*10).sorted().distinct().toList();
        System.out.println("There are "+evenCount+" elements are even out of "+count);
        for(int num: arr1){
            System.out.println(num);
        }
    }
}
