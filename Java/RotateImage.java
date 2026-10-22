import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        int[][] temp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[i][j]=matrix[j][i];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=temp[i][n-1-j];
            }
        }
    }
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        for(int i=0;i<arr.length;i++)
            System.out.println(Arrays.toString(arr[i]));
        rotate(arr);
    }
}
