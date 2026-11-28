import java.util.*;

class Solution {
    void bfs(Queue<int[]> q, boolean[][] vis, char[][] board, int m, int n) {
        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && board[nr][nc] == 'O') {
                    vis[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }
    }

    boolean isBoundary(int r, int c, int m, int n) {
        return r == 0 || r == m - 1 || c == 0 || c == n - 1;
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isBoundary(i, j, m, n) && board[i][j] == 'O') {
                    vis[i][j] = true;
                    q.add(new int[] { i, j });
                }
            }
        }

        bfs(q, vis, board, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}