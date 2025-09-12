class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        int temp = n;
        
        while (temp > 0) 
        {
            sb.insert(0, temp % k);
            temp /= k;
        }
        
        String baseK = sb.toString();

        String[] parts = baseK.split("0+");
        
        for (String p : parts) 
        {
            if (p.isEmpty())
            {
                continue;
            }
            
            long num = Long.parseLong(p); 

            if (isPrime(num))
            {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(long num) {
        
        if (num < 2)
        {
            return false;
        }
        
        for (long i = 2; i * i <= num; i++) 
        {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}
