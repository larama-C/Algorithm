class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 0;
        
        for (int stone : stones) {
            right = Math.max(right, stone);
        }
        
        int answer = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            boolean canCross = true;
            
            for (int stone : stones) {
                if (stone < mid) {
                    count++;
                    if (count >= k) {
                        canCross = false;
                        break;
                    }
                } else {
                    count = 0;
                }
            }
            
            if (canCross) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}