class Solution {
    public int solution(int[] numbers, int target) {
        int n = numbers.length;

        int sum = 0;
        for (int num : numbers)
        {
            sum += num;
        }

        int[][] dp = new int[n + 1][2 * sum + 1];
        dp[0][sum] = 1;

        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j <= 2 * sum; j++) 
            {
                if (dp[i][j] != 0) 
                {
                    int plus = j + numbers[i];
                    int minus = j - numbers[i];
                    
                    if (plus <= 2 * sum)
                    {
                        dp[i + 1][plus] += dp[i][j];
                    }
                    
                    if (minus >= 0)
                    {
                        dp[i + 1][minus] += dp[i][j];
                    }
                }
            }
        }

        return (target > sum) ? 0 : dp[n][target + sum];
    }
}
