class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right - (int)left + 1];
        
        for(long k = left; k <= right; k++) 
        {
            int i = (int)(k / n);
            int j = (int)(k % n);
            answer[(int)(k - left)] = Math.max(i + 1, j + 1);
        }
        
        return answer;
    }
}
