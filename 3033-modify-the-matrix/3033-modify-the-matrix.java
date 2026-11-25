class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] answer = new int[m][n];

        for (int col = 0; col < n; col++) {

            int maxVal = -1;
            for (int row = 0; row < m; row++) {
                maxVal = Math.max(maxVal, matrix[row][col]);
            }

            for (int row = 0; row < m; row++) {
                answer[row][col] = (matrix[row][col] == -1) ? maxVal : matrix[row][col];
            }
        }

        return answer;
    }
}
