class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][][] go = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                {
                    int r = i, c = j + 1;
                    int d = 0;
                    while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        if (d == 0) {
                            d = 1;
                            r += 1;
                        } else {
                            d = 0;
                            c += 1;
                        }
                    }
                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        go[i][j][0] = r * n + c;
                    } else {
                        go[i][j][0] = -1;
                    }
                }

                {
                    int r = i + 1, c = j;
                    int d = 1;
                    while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        if (d == 0) {
                            d = 1;
                            r += 1;
                        } else {
                            d = 0;
                            c += 1;
                        }
                    }
                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        go[i][j][1] = r * n + c;
                    } else {
                        go[i][j][1] = -1;
                    }
                }
            }
        }

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0)
                    continue;

                int targetRight = go[i][j][0];
                if (targetRight != -1) {
                    int nr = targetRight / n;
                    int nc = targetRight % n;
                    dp[nr][nc] = (dp[nr][nc] + dp[i][j]) % MOD;
                }

                int targetDown = go[i][j][1];
                if (targetDown != -1) {
                    int nr = targetDown / n;
                    int nc = targetDown % n;
                    dp[nr][nc] = (dp[nr][nc] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}
