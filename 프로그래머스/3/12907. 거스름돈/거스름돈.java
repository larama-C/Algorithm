class Solution {
    public int solution(int n, int[] money) {
        int MOD = 1000000007;
        int[] arr = new int[n + 1];
        
        arr[0] = 1;
        
        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                arr[i] = (arr[i] + arr[i - coin]) % MOD;
            }
        }
        
        return arr[n];
    }
}