class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122)
            {
                sb.append(s.charAt(i));
                for(int j = 0; j < arr.length; j++)
                {
                    if(sb.toString().equals(arr[j]))
                    {
                        answer.append(j);
                        sb.setLength(0);
                    }
                }
            }
            else
            {
                answer.append(s.charAt(i));
            }
            
        }
        
        return Integer.parseInt(answer.toString());
    }
}