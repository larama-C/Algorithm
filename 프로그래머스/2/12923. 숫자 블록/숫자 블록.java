class Solution {
    public int[] solution(long begin, long end) {
        
        int size = (int)(end - begin + 1);
        int[] answer = new int[size];
        
        for (long i = begin; i <= end; i++) {
            
            if (i == 1) {
                answer[(int)(i - begin)] = 0;
                continue;
            }
            
            int result = 1;
            
            for (long j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    long d = i / j;
                    
                    if (d <= 10000000) {
                        result = (int)d;
                        break;
                    }
                    
                    if (j <= 10000000) {
                        result = (int)j;
                    }
                }
            }
            
            answer[(int)(i - begin)] = result;
        }
        
        return answer;
    }
}