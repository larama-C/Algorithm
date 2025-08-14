class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int length = 0;
        int zero = 0;
        
        for(int a : lottos)
        {
            if(a == 0)
            {
                zero++;
                continue;
            }
            for(int b : win_nums)
            {
                if(a == b)
                {
                    length++;
                    break;
                }
            }
        }
        
        answer[0] = (length + zero) >= 2 ? 7 - (length + zero) : 6;
        answer[1] = (length >= 2) ? 7 - length : 6;
        
        return answer;
    }
}