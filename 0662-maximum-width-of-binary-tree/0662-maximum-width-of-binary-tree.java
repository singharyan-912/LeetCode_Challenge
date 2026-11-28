import java.util.*;

class Solution {
    private static class Pair {
        TreeNode node;
        long idx;

        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0L));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            long startIdx = q.peek().idx;
            long endIdx = startIdx;

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                TreeNode node = curr.node;
                long normIdx = curr.idx - startIdx;
                endIdx = curr.idx;

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * normIdx + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * normIdx + 2));
                }
            }

            int width = (int) (endIdx - startIdx + 1);
            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}