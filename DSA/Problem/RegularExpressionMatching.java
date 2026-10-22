package Problem;

import java.util.Scanner;

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;  // Empty string matches empty pattern

        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char beforeStar = p.charAt(j - 2);
                    // Zero occurrence or multiple matches
                    dp[i][j] = dp[i][j - 2] ||
                            ((beforeStar == '.' || beforeStar == sc) && dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str,pattern;
        System.out.print("Enter the string: ");
        str=in.nextLine();
        System.out.print("Enter the pattern: ");
        pattern=in.nextLine();
        System.out.println("Result: "+isMatch(str,pattern));
    }
}
