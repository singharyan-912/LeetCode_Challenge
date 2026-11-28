class Solution {
    private void bfs(int startR, int startC, boolean[][] vis, char[][] grid, int m, int n) {
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        Queue<int[]> q = new LinkedList<>();

        vis[startR][startC] = true;
        q.add(new int[] { startR, startC });

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n
                        && !vis[nr][nc] && grid[nr][nc] == '1') {
                    vis[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    islands++;
                    bfs(i, j, vis, grid, m, n);
                }
            }
        }

        return islands;
    }
}
