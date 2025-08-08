class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == ' ')
            {
                answer.append(' ');
                index = 0;
            }
            else
            {
                if(index % 2 == 0)
                {
                    answer.append(Character.toUpperCase(s.charAt(i)));
                }
                else
                {
                    answer.append(Character.toLowerCase(s.charAt(i)));
                }
                index++;
            }
        }
        return answer.toString();
    }
}