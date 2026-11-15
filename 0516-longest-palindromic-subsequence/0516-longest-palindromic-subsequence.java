class Solution {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        int[][] dp = new int[m][m];

        for (int i = 0; i < m; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= m; len++) {
            for (int left = 0; left <= m - len; left++) {
                int right = left + len - 1;

                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = 2 + (left + 1 <= right - 1 ? dp[left + 1][right - 1] : 0);
                } else {
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }

        return dp[0][m - 1];
    }
}
