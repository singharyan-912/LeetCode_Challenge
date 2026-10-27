class Solution {
    int solve(String word1, String word2, int m, int n, int[][] dp) {

        if (m < 0)
            return n + 1;

        if (n < 0)
            return m + 1;

        if (dp[m][n] != -1)
            return dp[m][n];

        char c = word1.charAt(m);
        char a = word2.charAt(n);

        if (c == a) {

            return dp[m][n] = solve(word1, word2, m - 1, n - 1, dp);
        } else {

            int deleteWord1 = solve(word1, word2, m - 1, n, dp);
            int deleteWord2 = solve(word1, word2, m, n - 1, dp);
            return dp[m][n] = 1 + Math.min(deleteWord1, deleteWord2);
        }
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            java.util.Arrays.fill(row, -1);
        }
        return solve(word1, word2, m - 1, n - 1, dp);
    }
}
