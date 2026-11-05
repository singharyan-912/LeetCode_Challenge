class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int s=0;
        int e=0;
        int max=0;
        int sum=0;
        while(e<nums.length){
            if(map.containsKey(nums[e]) && map.get(nums[e])>=s){
                int prev=map.get(nums[e]);
                while(s<=prev){
                    sum-=nums[s];
                    s++;
                } }            
            sum+=nums[e];
            
            map.put(nums[e],e);
            max=Math.max(max,sum);
            e++;
        }
        return max;
    }
}