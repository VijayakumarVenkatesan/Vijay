package Generic;

import java.util.ArrayList;
import java.util.List;

/*
Common type parameters
T - type
E - element
K - key
V - value
? - wildcard
*/


//Generic class
class Value<T>{
    private T value;
    public void set(T value){
        this.value=value;
    }
    public T get(){
        return value;
    }
}
public class BasicGenerics {

    //Generic method
    public static <T> void display(T value){
        System.out.println(value);
    }
    public static void main(String[] args) {
        Value<Integer> v=new Value<>();
        v.set(100);
        int result=v.get();

        //Wildcard
        List<? super String> str=new ArrayList<String>();
        str.add("Vijay");
        System.out.println(str);

        display("Vijayakumar");
        System.out.println(result);
    }
}
