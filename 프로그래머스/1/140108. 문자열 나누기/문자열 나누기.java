class Solution {
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        
        while(index < s.length())
        {
            char c = s.charAt(index);
            int correct = 0;
            int notcorrect = 0;
            for(int i = index; i < s.length(); i++)
            {
                if(c == s.charAt(i))
                {
                    correct++;
                }
                else
                {
                    notcorrect++;
                }
            
                if(correct == notcorrect)
                {
                    
                    index = i + 1;
                    answer++;
                    break;
                }
                
                if(i == s.length() - 1)
                {
                    answer++;
                    index = s.length();
                }
            }
        }
        return answer;
    }
}