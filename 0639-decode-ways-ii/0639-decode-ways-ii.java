import java.util.Arrays;

class Solution {
    private static final int MOD = 1000000007;

    private long solve(String s, int i, long[] dp) {
        if (i >= s.length()) {
            return 1;
        }

        char c1 = s.charAt(i);
        if (c1 == '0') {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        long ways = 0;

        if (c1 == '*') {
            ways = (ways + 9 * solve(s, i + 1, dp)) % MOD;
        } else {
            ways = (ways + solve(s, i + 1, dp)) % MOD;
        }

        if (i + 1 < s.length()) {
            char c2 = s.charAt(i + 1);

            if (c1 == '*' && c2 == '*') {
                ways = (ways + 15 * solve(s, i + 2, dp)) % MOD;
            } else if (c1 == '*') {
                int multiplier = (c2 <= '6') ? 2 : 1;
                ways = (ways + multiplier * solve(s, i + 2, dp)) % MOD;
            } else if (c2 == '*') {
                if (c1 == '1') {
                    ways = (ways + 9 * solve(s, i + 2, dp)) % MOD;
                } else if (c1 == '2') {
                    ways = (ways + 6 * solve(s, i + 2, dp)) % MOD;
                }
            } else {
                int val = (c1 - '0') * 10 + (c2 - '0');
                if (val >= 10 && val <= 26) {
                    ways = (ways + solve(s, i + 2, dp)) % MOD;
                }
            }
        }

        return dp[i] = ways;
    }

    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        Arrays.fill(dp, -1);
        return (int) solve(s, 0, dp);
    }
}