class Solution {
    int[][] dp;

    int solve(String s1, String s2, int m, int n) {
        if (m == 0) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += s2.charAt(j);
            }
            return sum;
        }
        if (n == 0) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += s1.charAt(i);
            }
            return sum;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        char a = s1.charAt(m - 1);
        char c = s2.charAt(n - 1);

        if (a == c) {
            return dp[m][n] = solve(s1, s2, m - 1, n - 1);
        } else {
            int deleteFromS1 = a + solve(s1, s2, m - 1, n);
            int deleteFromS2 = c + solve(s1, s2, m, n - 1);
            return dp[m][n] = Math.min(deleteFromS1, deleteFromS2);
        }
    }

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(s1, s2, m, n);
    }
}
