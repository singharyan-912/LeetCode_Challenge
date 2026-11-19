class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int []dp=new int [nums.length];
        int pa[]=new int[nums.length];
        int maxlen=0;
        int curr=-1;
        for(int i=0;i<nums.length;i++){
            pa[i]=i;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
          for(int j=i-1;j>=0;j--){
            if(nums[i]%nums[j]==0){
               if(dp[j]+1>dp[i]){
                dp[i]=dp[j]+1;
                pa[i]=j;
               }
            }
          }
        }
        for(int i=0;i<nums.length;i++){
            if(dp[i]>maxlen){
                maxlen=dp[i];
                curr=i;
            }}
            while(pa[curr]!=curr){
                ans.add(nums[curr]);
                curr=pa[curr];
            }
        
        ans.add(nums[curr]);
        Collections.reverse(ans);

     return ans;
    }
}