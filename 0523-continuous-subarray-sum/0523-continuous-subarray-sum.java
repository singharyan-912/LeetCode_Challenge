class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for (int e = 0; e < n; e++) {
            sum += nums[e];
            int rem = sum % k;

            if (map.containsKey(rem)) {
                if (e - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, e);
            }
        }

        return false;
    }
}
