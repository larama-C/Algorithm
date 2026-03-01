class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        
        long current1 = 0;
        long current2 = 0;
        
        for (int i = 0; i < sequence.length; i++) {
            
            long val1;
            long val2;
            
            if (i % 2 == 0) {
                val1 = sequence[i];
                val2 = -sequence[i];
            } else {
                val1 = -sequence[i];
                val2 = sequence[i];
            }
            
            current1 = Math.max(val1, current1 + val1);
            current2 = Math.max(val2, current2 + val2);
            
            answer = Math.max(answer, Math.max(current1, current2));
        }
        
        return answer;
    }
}