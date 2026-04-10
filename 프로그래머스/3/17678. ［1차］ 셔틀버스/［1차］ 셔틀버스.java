import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] crew = new int[timetable.length];

        for (int i = 0; i < timetable.length; i++) {
            String time = timetable[i];
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            crew[i] = hour * 60 + minute;
        }

        Arrays.sort(crew);

        int idx = 0;
        int busTime = 9 * 60;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            int lastBoardedTime = -1;

            while (idx < crew.length && crew[idx] <= busTime && count < m) {
                lastBoardedTime = crew[idx];
                idx++;
                count++;
            }

            if (i == n - 1) {
                if (count < m) {
                    answer = busTime;
                } else {
                    answer = lastBoardedTime - 1;
                }
            }

            busTime += t;
        }

        int hour = answer / 60;
        int minute = answer % 60;

        String hh = hour < 10 ? "0" + hour : String.valueOf(hour);
        String mm = minute < 10 ? "0" + minute : String.valueOf(minute);

        return hh + ":" + mm;
    }
}