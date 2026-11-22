class Solution {
    int solve(int[] nums, int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (i == j)
            return nums[i];
        if (dp[i][j] != -1)
            return dp[i][j];

        int takeS = nums[i] + Math.min(solve(nums, i + 2, j, dp), solve(nums, i + 1, j - 1, dp));
        int takeE = nums[j] + Math.min(solve(nums, i + 1, j - 1, dp), solve(nums, i, j - 2, dp));

        return dp[i][j] = Math.max(takeS, takeE);
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ts = 0;
        for (int i = 0; i < n; i++) {
            ts += nums[i];
        }

        int p1 = solve(nums, 0, n - 1, dp);
        int p2 = ts - p1;

        return p1 >= p2;
    }
}
