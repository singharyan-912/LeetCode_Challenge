class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int s = 0;
        int e = 1;
        int maxlength = 1;
        while (e < nums.length) {
            if (nums[e] <= nums[e-1]) {
                s = e;
            }
            maxlength = Math.max(e - s + 1, maxlength);
            e++;
        }
        s=0;e=1;
        while (e < nums.length) {
            if (nums[e] >= nums[e-1]) {
                s = e;
            }
             maxlength = Math.max(e - s + 1, maxlength);
            e++;
        }
         return maxlength;
    }

}
