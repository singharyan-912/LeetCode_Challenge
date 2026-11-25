class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }

        int lis = 0;
        for (int i = 0; i < n; i++) {
            lis = Math.max(lis, Math.max(up[i], down[i]));
        }
        return lis;
    }
}
