import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) 
        {
            startTimes[i] = toMinutes(book_time[i][0]);
            endTimes[i] = toMinutes(book_time[i][1]) + 10;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int answer = 0, rooms = 0;
        int i = 0, j = 0;

        while (i < n && j < n) 
        {
            if (startTimes[i] < endTimes[j]) 
            {
                rooms++;
                answer = Math.max(answer, rooms);
                i++;
            }
            else
            {
                rooms--;
                j++;
            }
        }

        return answer;
    }

    private int toMinutes(String t) 
    {
        String[] parts = t.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
