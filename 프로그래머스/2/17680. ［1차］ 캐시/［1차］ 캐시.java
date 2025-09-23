import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        LinkedList<String> cacheList = new LinkedList<>();
        HashMap<String, Boolean> cacheMap = new HashMap<>();
        int time = 0;

        for (String city : cities) 
        {
            city = city.toLowerCase();

            if (cacheMap.containsKey(city)) 
            {
                time += 1;
                cacheList.remove(city);
                cacheList.addLast(city);
            } 
            else 
            {
                time += 5;
                if (cacheList.size() == cacheSize)
                {
                    String removed = cacheList.removeFirst();
                    cacheMap.remove(removed);
                }
                cacheList.addLast(city);
                cacheMap.put(city, true);
            }
        }

        return time;
    }
}
