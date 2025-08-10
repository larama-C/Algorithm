class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int c1idx = 0;
        int c2idx = 0;
        
        for(int i = 0; i < goal.length; i++)
        {
            if(c1idx < cards1.length && cards1[c1idx].equals(goal[i]))
            {
                c1idx++;
            }
            else if(c2idx < cards2.length && cards2[c2idx].equals(goal[i]))
            {
                c2idx++;
            }
            else
            {
                return "No";
            }
        }
        
        return "Yes";
    }
}