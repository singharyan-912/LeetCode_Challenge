class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;

        int zeroIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIdx = i;
                break;
            }
        }

        boolean isIncRot = true;
        for (int i = 0; i < n; i++) {
            if (nums[(zeroIdx + i) % n] != i) {
                isIncRot = false;
                break;
            }
        }

        int maxIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == n - 1) {
                maxIdx = i;
                break;
            }
        }

        boolean isDecRot = true;
        for (int i = 0; i < n; i++) {
            if (nums[(maxIdx + i) % n] != n - 1 - i) {
                isDecRot = false;
                break;
            }
        }

        if (!isIncRot && !isDecRot) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;

        if (isIncRot) {
            ans = Math.min(ans, zeroIdx);
            ans = Math.min(ans, 2 + (n - zeroIdx) % n);
        }

        if (isDecRot) {
            ans = Math.min(ans, 1 + (n - maxIdx) % n);
            ans = Math.min(ans, maxIdx + 1);
        }

        return ans;
    }
}
