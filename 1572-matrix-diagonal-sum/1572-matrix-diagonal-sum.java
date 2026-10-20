class Solution {
    int solve1(int[][] mat, int m, int n, int r, int c) {
        int ld = 0;
        if (r < m && c >= 0) {
            ld = mat[r][c] + solve1(mat, m, n, r + 1, c - 1);
        }
        return ld;
    }

    int solve(int[][] mat, int m, int n, int r, int c) {
        int rd = 0;
        if (r < m && c < n) {
            rd = mat[r][c] + solve(mat, m, n, r + 1, c + 1);
        }
        return rd;
    }

    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int primary = solve(mat, m, n, 0, 0);
        int secondary = solve1(mat, m, n, 0, n - 1);

        int center = (m % 2 != 0) ? mat[m / 2][n / 2] : 0;

        return primary + secondary - center;
    }
}
