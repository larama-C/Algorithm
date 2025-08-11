class Solution {
    public String solution(int a, int b) {
        String[] answer = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int day = 0;

        while (a > 1) {
            a--;

            if (a == 2) {
                day += 29;
            } else if (a <= 7) {
                if (a % 2 == 0) {
                    day += 30;
                } else {
                    day += 31;
                }
            } else {
                if (a % 2 == 0) {
                    day += 31;
                } else {
                    day += 30;
                }
            }
        }

        day += b - 1;
        return answer[day % 7];
    }
}