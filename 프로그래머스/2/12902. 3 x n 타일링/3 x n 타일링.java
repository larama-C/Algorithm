class Solution {
    private static final int MOD = 1_000_000_007;

    public int solution(int n) {
        if (n % 2 == 1) return 0;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        if (n >= 2) dp[2] = 3;

        long extra = 0;

        for (int i = 4; i <= n; i += 2) {
            extra = (extra + dp[i - 4]) % MOD;
            dp[i] = (dp[i - 2] * 3 + extra * 2) % MOD;
        }

        return (int) dp[n];
    }
}