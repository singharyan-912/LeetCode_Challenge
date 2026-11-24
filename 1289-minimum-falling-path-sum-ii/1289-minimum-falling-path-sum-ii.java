import java.util.Arrays;

class Solution {
    private static final int INF = 1_000_000_000;

    private int solve(int[][] grid, int m, int n, int r, int c, int[][] dp) {
        if (r == m - 1) {
            return grid[r][c];
        }
        if (dp[r][c] != Integer.MIN_VALUE) {
            return dp[r][c];
        }

        int bestNext = INF;
        for (int nextCol = 0; nextCol < n; nextCol++) {
            if (nextCol != c) {
                bestNext = Math.min(bestNext, solve(grid, m, n, r + 1, nextCol, dp));
            }
        }

        return dp[r][c] = grid[r][c] + bestNext;
    }

    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1) {
            int ans = Integer.MAX_VALUE;
            for (int c = 0; c < n; c++) {
                ans = Math.min(ans, grid[0][c]);
            }
            return ans;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        int minSum = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            minSum = Math.min(minSum, solve(grid, m, n, 0, c, dp));
        }
        return minSum;
    }
}