
class Solution {
    public int lengthOfLIS(int[] nums) {
        int m = nums.length;

        int[][] dp = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = i - 1; j >= -1; j--) {

                int take = 0;

                if (j == -1 || nums[j] < nums[i]) {
                    take = 1 + dp[i + 1][i + 1];
                }

                int skip = dp[i + 1][j + 1];

                dp[i][j + 1] = Math.max(take, skip);
            }
        }

        return dp[0][0];
    }
}
