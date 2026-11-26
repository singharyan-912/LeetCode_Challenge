class Solution {

    void bfs(int start, Queue<Integer> q, boolean vis[], ArrayList<ArrayList<Integer>> ans) {
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int j = 0; j < ans.get(temp).size(); j++) {
                int neigh = ans.get(temp).get(j);
                if (!vis[neigh]) {
                    q.add(neigh);
                    vis[neigh] = true;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean vis[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    ans.get(i).add(j);
                }
            }
        }

        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                provinces++;
                bfs(i, q, vis, ans);
            }
        }

        return provinces;
    }
}
