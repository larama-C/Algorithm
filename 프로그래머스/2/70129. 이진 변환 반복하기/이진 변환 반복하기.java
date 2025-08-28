class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int sum = 0;
        int cnt = 0;
        
        while (!s.equals("1")) 
        {
            cnt++;
            
            while (s.contains("0")) 
            {
                s = s.replaceFirst("0", "");
                sum++;
            }
            
            s = Integer.toBinaryString(s.length());
        }
        
        return answer = new int[]{cnt, sum};
    }
}