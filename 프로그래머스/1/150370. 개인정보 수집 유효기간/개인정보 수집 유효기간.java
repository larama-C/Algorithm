import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> termmap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termmap.put(parts[0], Integer.parseInt(parts[1]));
        }
        
        String[] todayparts = today.split("\\.");
        int tyear = Integer.parseInt(todayparts[0]);
        int tmonth = Integer.parseInt(todayparts[1]);
        int tday = Integer.parseInt(todayparts[2]);
        int todayInt = tyear * 10000 + tmonth * 100 + tday;
        
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            String date = parts[0];
            String term = parts[1];
            int months = termmap.get(term);
            
            if (dateAdd(date, months, todayInt)) {
                answer.add(i + 1);
            }
        }
        
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private boolean dateAdd(String date, int monthAdd, int todayInt) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        month += monthAdd;
        while (month > 12)
        {
            year += 1;
            month -= 12;
        }
        
        int expiryInt = year * 10000 + month * 100 + day;
        return expiryInt <= todayInt;
    }
}