import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayPrimeSum {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the array length:");
        int len=in.nextInt();
        int[] arr = new int[len];
        System.out.println("Enter array elements:");
        for(int i=0;i<len;i++){
            System.out.print("arr["+i+"]=");
            arr[i]=in.nextInt();
        }
        ArrayList<Integer> prime = new ArrayList<>();
        int sum = 0;

        for (int j : arr) {
            if (isPrime(j)) {
                prime.add(j);
                sum += j;
            }
        }
        Collections.sort(prime);
        System.out.println("Sorted Prime Numbers: " + prime);
        System.out.println("Sum of Prime Numbers: " + sum);
    }
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
