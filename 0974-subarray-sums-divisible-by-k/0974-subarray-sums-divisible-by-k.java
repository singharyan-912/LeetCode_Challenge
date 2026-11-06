class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;

        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            int rem = prefixSum % k;
            if (rem < 0) {
                rem += k;
            }

            if (remainderMap.containsKey(rem)) {
                count += remainderMap.get(rem);
            }

            remainderMap.put(rem, remainderMap.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
