class Solution {
    int solve(int[][] nums, int n,int m, int r, int c, int[][] dp) {
        if (r >= m  || c >= n   || nums[r][c]==1)
            return 0;
        if (r == m - 1 && c == n - 1)
            return 1;
        if (dp[r][c] != -1)
            return dp[r][c];

        int down = solve(nums, n,m, r + 1, c, dp);
        int right = solve(nums, n,m, r, c + 1, dp);
        return dp[r][c] = down + right;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
           int n=obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(obstacleGrid, n,m, 0, 0, dp);
    }
}