import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, List<String>> map = new HashMap<>();
    
        for(int i = 0; i < clothes.length; i++)
        {
            String item = clothes[i][0];
            String type = clothes[i][1];
            
            if (map.containsKey(type)) {
                map.get(type).add(item);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(item);
                map.put(type, list);
            }
        }
        
        for(String key : map.keySet())
        {
            answer *= (map.get(key).size() + 1);
        }
        
        answer -=1;
        
        return answer;
    }
}