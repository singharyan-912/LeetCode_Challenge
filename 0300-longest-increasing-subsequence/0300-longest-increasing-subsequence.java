class Solution {
    int solve(int[] nums, int i, int j, int[][] dp) {
        if (i >= nums.length)
            return 0;

        if (dp[i][j + 1] != -1)
            return dp[i][j + 1];

        int take = 0;

        if (j == -1 || nums[j] < nums[i]) {
            take = 1 + solve(nums, i + 1, i, dp);
        }
        int skip = solve(nums, i + 1, j, dp);

        return dp[i][j + 1] = Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int m = nums.length;

        int[][] dp = new int[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, 0, -1, dp);
    }
}
