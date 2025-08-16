import java.util.*;

class Solution
{
    public String[] solution(String[] players, String[] callings)
    {
        String[] answer = players.clone();
        Map<String, Integer> pos = new HashMap<>();

        for (int i = 0; i < answer.length; i++)
        {
            pos.put(answer[i], i);
        }

        for (String name : callings)
        {
            int idx = pos.get(name);

            if (idx > 0)
            {
                String prev = answer[idx - 1];

                answer[idx - 1] = name;
                answer[idx] = prev;

                pos.put(name, idx - 1);
                pos.put(prev, idx);
            }
        }

        return answer;
    }
}
