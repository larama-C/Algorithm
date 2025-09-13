import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String record : records) 
        {
            String[] spl = record.split(" ");
            map.putIfAbsent(spl[1], new ArrayList<>());
            map.get(spl[1]).add(spl[0]);
        }
        
        List<String> cars = new ArrayList<>(map.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) 
        {
            String car = cars.get(i);
            List<String> times = map.get(car);
            
            int totalTime = 0;
            for (int j = 0; j < times.size(); j += 2) 
            {
                int inTime = toMinutes(times.get(j));
                int outTime;
                if (j + 1 < times.size())
                {
                    outTime = toMinutes(times.get(j + 1));
                }
                else 
                {
                    outTime = toMinutes("23:59");
                }
                totalTime += outTime - inTime;
            }
            
            int fee = fees[1];
            if (totalTime > fees[0]) 
            {
                fee += (int)Math.ceil((totalTime - fees[0]) / (double)fees[2]) * fees[3];
            }
            
            answer[i] = fee;
        }
        
        return answer;
    }
    
    private int toMinutes(String time) 
    {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}
