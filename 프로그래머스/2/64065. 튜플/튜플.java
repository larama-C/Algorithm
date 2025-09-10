import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("\\},\\{");
        
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        
        Set<Integer> answerSet = new LinkedHashSet<>();
        for (String str : arr) 
        {
            String[] nums = str.split(",");
            for (String num : nums) 
            {
                answerSet.add(Integer.parseInt(num));
            }
        }
        
        
        int[] answer = new int[answerSet.size()];
        int idx = 0;
        for (int num : answerSet) 
        {
            answer[idx++] = num;
        }
        
        return answer;
    }
}
