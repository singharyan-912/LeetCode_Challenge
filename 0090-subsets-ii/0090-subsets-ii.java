class Solution {
    private void solve(int[] nums, int index, List<Integer> curr, List<List<Integer>> ans, boolean choosePre) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        solve(nums, index + 1, curr, ans, false);

        if (index > 0 && nums[index] == nums[index - 1] && !choosePre) {
            return;
        }

        curr.add(nums[index]);
        solve(nums, index + 1, curr, ans, true);
        curr.remove(curr.size() - 1); // backtrack
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), ans, false);
        return ans;
    }
}
