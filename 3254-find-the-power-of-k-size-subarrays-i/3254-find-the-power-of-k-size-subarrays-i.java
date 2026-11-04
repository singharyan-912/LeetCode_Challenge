class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int s=0;
        int e=0;
        int count=0;
        int []ans=new int[nums.length-k+1];
        while(e<nums.length){
            if(e>0 && nums[e]!=nums[e-1]+1){
                count=1;
            }else{
                count++;
            }
            if(e-s+1==k){
                if(count>=k){
                    ans[s]=nums[e];
                }else{
                    ans[s]=-1;
                }
                s++;
            }
            e++;
            
        }
        return ans;
    }
}