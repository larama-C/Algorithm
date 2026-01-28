class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long d2 = (long) d * d;

        for (long x = 0; x <= d; x += k) {
            long remain = d2 - x * x;
            long maxY = (long) Math.sqrt(remain);
            answer += (maxY / k) + 1;
        }

        return answer;
    }
}