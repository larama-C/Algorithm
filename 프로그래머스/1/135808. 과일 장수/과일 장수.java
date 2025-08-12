import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int s : score) {
            list.add(s);
        }
        
        list.sort(Collections.reverseOrder());
        
        for(int i = 0; i + m <= list.size(); i+= m)
        {
            int min = list.get(i + m - 1);
            answer += min * m;
        }
        
        return answer;
    }
}