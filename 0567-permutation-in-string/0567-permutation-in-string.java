class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m){
            return false;
        }
        int []count=new int[26];
        int []count1=new int[26];
        for(int i=0;i<n;i++){
          count[s1.charAt(i)-'a']++;
          count1[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(count,count1)){
            return true;
        }
        for(int i=n;i<m;i++){
          count1[s2.charAt(i)-'a']++;
          count1[s2.charAt(i-n)-'a']--;
           if(Arrays.equals(count,count1)){
                  return true;
           }
                             
           }
           return false;
        }
    }
