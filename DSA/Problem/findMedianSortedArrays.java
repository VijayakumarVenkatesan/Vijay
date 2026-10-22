package Problem;

import java.util.Arrays;
import java.util.Scanner;

public class findMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res;
        int[] num=new int[nums1.length+nums2.length];
        int l=nums1.length+nums2.length;
        for(int i=0;i<nums1.length;i++) num[i]=nums1[i];
        for(int i=0;i<nums2.length;i++) num[nums1.length+i]=nums2[i];
        Arrays.sort(num);
        if(l%2!=0) return res=num[l/2];
        else return res=(num[l/2-1]+num[l/2])/2.0;
    }

    public static void main(String[] args) {
        int l1,l2;
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the size of the first array:");
        l1=in.nextInt();
        System.out.print("Enter the size of the second array:");
        l2=in.nextInt();
        int[] arr1=new int[l1];
        int[] arr2=new int[l2];
        System.out.println("Enter the elements for the first array:");
        for(int i=0;i<l1;i++){
            System.out.print("arr1["+i+"]=");
            arr1[i]=in.nextInt();
            System.out.println();
        }
        System.out.println("Enter the elements for the second array:");
        for(int i=0;i<l2;i++){
            System.out.print("arr2["+i+"]=");
            arr1[i]=in.nextInt();
            System.out.println();
        }
        double median=findMedianSortedArrays(arr1,arr2);
        System.out.println("The median of the two merged arrays:"+median);
    }
}
