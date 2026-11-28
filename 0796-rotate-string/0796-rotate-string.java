class Solution {
    public boolean rotateString(String s, String goal) {
        int m=s.length();
        int n=goal.length();
        if(m!=n){
            return false;
        }
        String doubled = s+s;
        return doubled.contains(goal);
    }
}