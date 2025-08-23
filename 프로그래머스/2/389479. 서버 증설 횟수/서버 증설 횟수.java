class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] Server = new int[players.length];
        
        for(int i = 0; i < players.length; i++)
        {
            if(players[i] / m <= Server[i]) continue;
            
            for (int j=1; j<k && (i+j) < Server.length; j++)
            {
                Server[i+j] += (players[i] / m - Server[i]);
            }
            answer += players[i] / m - Server[i];
        }
        
        return answer;
    }
}