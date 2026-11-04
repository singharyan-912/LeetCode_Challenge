class Solution {
    public int longestOnes(int[] nums, int k) {
        int s=0;int e=0;
        int maxone=0;
       while(e<nums.length){
          if(nums[e]==0){
            k--;
          }
          while(k<0){
            if(nums[s]==0){
                k++;
            }
            s++;
          }
          maxone=Math.max(maxone,e-s+1);
          e++;
       }
       return maxone;
    }
}