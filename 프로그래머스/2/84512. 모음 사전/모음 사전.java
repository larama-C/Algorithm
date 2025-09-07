class Solution {
    public int solution(String word) {
        int[] size = {781, 156, 31, 6, 1};
        int answer = 0;
        char[] arr = {'A','E','I','O','U'};
        
        for(int i = 0; i < word.length(); i++)
        {
            int idx = 0;
            for(int j = 0; j < arr.length; j++)
            {
                if(word.charAt(i) == arr[j])
                {
                    idx = j;
                    break;
                }
            }
            answer += idx * size[i] + 1;
        }
        
        return answer;
    }
}