public class Solution {
    public int solution(int n) {
        int count = 0;
        
        for (int i = 1; i <= n; i++) 
        {
            int x = n - i * (i - 1) / 2;
            
            if (x <= 0)
            {
                break;
            }
            
            if (x % i == 0)
            {
                count++;
            }
        }
        
        return count;
    }
}