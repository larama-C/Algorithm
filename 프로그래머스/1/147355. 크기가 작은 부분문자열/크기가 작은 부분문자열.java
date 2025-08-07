class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        int count = t.length() - len + 1;
        String[] result = new String[count];

        for (int i = 0; i < count; i++) {
            result[i] = t.substring(i, i + len);
            if(Long.parseLong(result[i]) <= Long.parseLong(p))
            {
                answer++;
            }
        }
        
        return answer;
    }
}