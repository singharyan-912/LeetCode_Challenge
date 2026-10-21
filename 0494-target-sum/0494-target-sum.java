import java.util.HashMap;

class Solution {
    int solve(int[] nums, int target, int currsum, int i, HashMap<String, Integer> memo) {
        if (i == nums.length) {
            if (currsum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        String key = currsum + "," + i;
        if (memo.containsKey(key))
            return memo.get(key);

        int pos = solve(nums, target, currsum + nums[i], i + 1, memo);
        int neg = solve(nums, target, currsum - nums[i], i + 1, memo);

        int ways = pos + neg;
        memo.put(key, ways);
        return ways;
    }

    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> memo = new HashMap<>();
        return solve(nums, target, 0, 0, memo);
    }
}