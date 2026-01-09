class Solution {
    public int[] solution(int money) {
        int price = 5500;
        
        int count = money / price;
        int remain = money % price;
        
        return new int[] { count, remain };
    }
}