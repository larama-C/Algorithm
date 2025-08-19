class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < timelogs.length; i++) 
        {
            boolean ok = true;

            for (int j = 0; j < timelogs[i].length; j++) 
            {
                int weekday = (startday + j - 1) % 7 + 1;
                
                if (weekday >= 1 && weekday <= 5) 
                {
                    int limit = time(schedules[i], 10);
                    
                    if (timelogs[i][j] > limit) 
                    {
                        ok = false;
                        break;
                    }
                }
            }

            if (ok)
            {
                answer++;
            }
        }

        return answer;
    }

    public int time(int t, int plus) {
        int hour = t / 100;
        int min = t % 100;

        min += plus;
        if (min >= 60) 
        {
            hour += min / 60;
            min %= 60;
        }

        return hour * 100 + min;
    }
}
