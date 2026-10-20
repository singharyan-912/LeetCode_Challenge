class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][] maxDp = new long[m][n];
        long[][] minDp = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    maxDp[i][j] = grid[i][j];
                    minDp[i][j] = grid[i][j];
                    continue;
                }

                long maxVal = Long.MIN_VALUE;
                long minVal = Long.MAX_VALUE;

                if (i > 0) {
                    long p1 = maxDp[i - 1][j] * grid[i][j];
                    long p2 = minDp[i - 1][j] * grid[i][j];
                    maxVal = Math.max(maxVal, Math.max(p1, p2));
                    minVal = Math.min(minVal, Math.min(p1, p2));
                }

                if (j > 0) {
                    long p1 = maxDp[i][j - 1] * grid[i][j];
                    long p2 = minDp[i][j - 1] * grid[i][j];
                    maxVal = Math.max(maxVal, Math.max(p1, p2));
                    minVal = Math.min(minVal, Math.min(p1, p2));
                }

                maxDp[i][j] = maxVal;
                minDp[i][j] = minVal;
            }
        }

        long ans = maxDp[m - 1][n - 1];
        if (ans < 0)
            return -1;
        return (int) (ans % 1000000007);
    }
}
