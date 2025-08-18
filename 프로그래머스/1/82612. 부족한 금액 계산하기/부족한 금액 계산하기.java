class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        return answer = price * (long)(count * (count + 1) / 2) > money ? price * (long)(count * (count + 1) / 2) - money : 0;
    }
}