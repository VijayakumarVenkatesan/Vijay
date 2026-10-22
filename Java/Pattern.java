public class Pattern {
    public static void main(String[] args) {
        int n = 11;
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                if ((i + j >= n / 2 && i + j <= n - 1 + n / 2) &&
                        (i - j <= n / 2 && j - i <= n / 2)) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
        }
    }
}
