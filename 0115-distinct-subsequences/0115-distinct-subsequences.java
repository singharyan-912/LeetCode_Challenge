class Solution {
    int solve(String s, String t, int m, int n, int[][] dp) {
        if (n < 0)
            return 1;
        if (m < 0)
            return 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        int count = 0;
        char a = s.charAt(m);
        char c = t.charAt(n);

        if (a == c) {
            count = solve(s, t, m - 1, n - 1, dp) + solve(s, t, m - 1, n, dp);
        } else {
            count = solve(s, t, m - 1, n, dp);
        }
        return dp[m][n] = count;
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, t, m - 1, n - 1, dp);
    }
}
