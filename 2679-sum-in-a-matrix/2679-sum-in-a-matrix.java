import java.util.Arrays;

class Solution {
    public int matrixSum(int[][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;

        for (int[] row : nums) {
            Arrays.sort(row);
        }

        int score = 0;

        for (int col = cols - 1; col >= 0; col--) {
            int maxInCol = 0;
            for (int row = 0; row < rows; row++) {
                maxInCol = Math.max(maxInCol, nums[row][col]);
            }
            score += maxInCol;
        }

        return score;
    }
}