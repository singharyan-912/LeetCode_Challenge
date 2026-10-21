class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return ans;

        int m = matrix.length;
        int n = matrix[0].length;
        spiralHelper(matrix, 0, m - 1, 0, n - 1, ans);
        return ans;
    }

    private void spiralHelper(int[][] matrix, int top, int bottom, int left, int right, List<Integer> ans) {

        if (top > bottom || left > right) {
            return;
        }

        for (int i = left; i <= right; i++) {
            ans.add(matrix[top][i]);
        }

        for (int i = top + 1; i <= bottom; i++) {
            ans.add(matrix[i][right]);
        }

        if (top != bottom) {
            for (int i = right - 1; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
        }

        if (left != right) {
            for (int i = bottom - 1; i > top; i--) {
                ans.add(matrix[i][left]);
            }
        }

        spiralHelper(matrix, top + 1, bottom - 1, left + 1, right - 1, ans);
    }
}
