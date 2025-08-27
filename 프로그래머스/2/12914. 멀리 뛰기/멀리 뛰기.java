class Solution {
    public long solution(int n) {
        long answer = 0;
        long first = 1;
        long second = 2;
        int num = n;
        
        if(n <= 2)
        {
            return n == 1 ? first : second;
        }
        else
        {
            while(n > 2)
            {      
            
            answer = (first + second) % 1234567;
            first = second;
            second = answer;
            n--;
            }
        }
        
        return answer;   
    }
}