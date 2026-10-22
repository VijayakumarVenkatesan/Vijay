public class ArrayProduct {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = nums.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++) System.out.print(nums[i]+" ");
        System.out.println();
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++)
            left[i] = left[i - 1] * nums[i - 1];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            right[i] = right[i + 1] * nums[i + 1];
        for(int i=0;i<n;i++) System.out.print(left[i]+" ");
        System.out.println();
        for(int i=0;i<n;i++) System.out.print(right[i]+" ");
        System.out.println();
        for (int i = 0; i < n; i++)
            answer[i] = left[i] * right[i];
        for (int val : answer)
            System.out.print(val + " ");
    }
}
