class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int deliveryBox = 0;
        int pickupBox = 0;

        for (int i = n - 1; i >= 0; i--) {
            deliveryBox += deliveries[i];
            pickupBox += pickups[i];

            while (deliveryBox > 0 || pickupBox > 0) {
                deliveryBox -= cap;
                pickupBox -= cap;
                answer += (i + 1) * 2L;
            }
        }

        return answer;
    }
}