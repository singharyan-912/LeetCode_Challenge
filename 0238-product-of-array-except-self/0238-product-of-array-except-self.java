class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int [] ans=new int[n];
        int lp=1;
        for(int i=0;i<n;i++){
            
            ans[i]=lp;
            lp*=nums[i];
        }
        int rp=1;
        for(int i=n-1;i>=0;i--){
             ans[i]=ans[i]*rp;
              rp*=nums[i];
            
        }
       return ans;
    }
}