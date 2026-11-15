class Solution {
    public int numOfSubarrays(int[] arr) {
        long odd = 0;
        long even = 1;
        long sum = 0;
        long res = 0;
        int mod = 1000000007;

        for (int num : arr) {
            sum += num;
            if (sum % 2 != 0) {
                res = (res + even) % mod;
                odd++;
            } else {
                res = (res + odd) % mod;
                even++;
            }
        }

        return (int) res;
    }
}
