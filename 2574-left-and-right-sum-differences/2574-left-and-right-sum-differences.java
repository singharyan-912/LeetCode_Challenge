class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int totalsum=0;
        int []ans=new int[n];
        for(int i=0;i<n;i++){
            totalsum+=nums[i];
        }
       int leftsum=0;
        for(int i=0;i<n;i++){
            int suffixsum=totalsum-leftsum-nums[i];
            ans[i]=Math.abs(leftsum-suffixsum);
             leftsum+=nums[i];
        }
       
     return ans;

    }
}