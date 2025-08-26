class Solution {
    public int solution(int n) {
        int a = 0, b = 1;
        int sol = 0;
        
        for(int i = 2; i <= n; i++)
        {
            sol = (a + b) % 1234567;
            a = b;
            b = sol;
        }
        
        return sol;
    }
}