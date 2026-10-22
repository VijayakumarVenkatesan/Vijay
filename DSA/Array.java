import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Array {
    //Second largest
    public static int secondLargest(int [] arr){
        int largest=Integer.MIN_VALUE,second=Integer.MIN_VALUE;
        for(int num:arr){
            if(num>largest){
                second=largest;
                largest=num;
            }
            else if(num!=largest&&num<second){
                second=num;
            }
        }
        if(second==Integer.MIN_VALUE) return 0;
        else return second;
    }

    //Remove duplicate
    public static void removeDuplicate(int[] arr){
        LinkedHashSet<Integer> ans=new LinkedHashSet<>();
        for(int num:arr){
            ans.add(num);
        }
        System.out.print("The array without duplicate elements: ");
        for(int num:ans){
            System.out.print(num+" ");
        }
    }

    //Left rotation
    public static void leftRotation(int[] arr,int k){
        int[] res=new int[arr.length];
        k=k%res.length;
        for(int i=0;i<arr.length;i++){
            res[i]=arr[(i+k)%res.length];
        }
        System.out.println("The left rotated array by "+k+" steps "+Arrays.toString(res));
    }

    //Right rotation
    public static void rightRotation(int[] arr,int k){
        int[] res=new int[arr.length];
        k=k%res.length;
        for(int i=0;i<arr.length;i++){
            res[i]=arr[(i+k+1)%res.length];
        }
        System.out.println("The left rotated array by "+k+" steps "+Arrays.toString(res));
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
//        System.out.print("Enter array size:");
//        int size=in.nextInt();
        int [] arr={1,2,3,4,5};
        int second=secondLargest(arr);
        System.out.println("The second largest element in the array "+second);

        removeDuplicate(arr);

        //Array using collection
//        ArrayList<Integer> a=new ArrayList<Integer>();
//        a.add(100);
//        a.add(200);
//        arr[0]=1000;

        System.out.print("\nArray rotation:\n1.Left rotation\n2.Right rotation\nSelect the rotation:");
        int rotation=in.nextInt(),k;
        System.out.print("Enter the no. of rotation:");
        k=in.nextInt();
        switch (rotation){
            case 1:{
                leftRotation(arr,k);
                break;
            }
            case 2:{
                rightRotation(arr,k);
                break;
            }
            default:
                System.out.println("Invalid option");
        }
    }
}
/*
 Beginner Level
Find the largest/smallest element

Sum of array elements

Find the average of elements

Check if array contains a given value

Reverse the array

Count even and odd numbers

Print only positive/negative numbers

Find the second largest element

Merge two arrays

Remove duplicates from array

🔹 Intermediate Level
Left rotate/right rotate the array by k steps

Sort array without using built-in sort

Find missing number in a sequence

Count frequency of elements

Find common elements in two arrays

Move all zeros to the end

Check if array is a palindrome

Find duplicate elements

Find all pairs with given sum

Kadane's Algorithm (Maximum Subarray Sum)

🔹 Advanced Level
Two Sum / Three Sum Problem

Subarray with given sum (sliding window)

Product of array except self

Next Greater Element

Find the majority element

Rotate matrix by 90 degrees

Spiral order traversal of matrix

Count inversions in array

Trapping Rain Water Problem

Longest Consecutive Sequence
 */
