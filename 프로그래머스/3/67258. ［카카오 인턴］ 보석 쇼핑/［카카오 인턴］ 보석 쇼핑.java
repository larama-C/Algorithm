import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String g : gems) {
            set.add(g);
        }
        int kind = set.size();

        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int bestLen = Integer.MAX_VALUE;
        int[] answer = {1, gems.length};

        while (right < gems.length) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

            while (map.size() == kind) {
                if (right - left < bestLen) {
                    bestLen = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }

                String gem = gems[left];
                map.put(gem, map.get(gem) - 1);
                if (map.get(gem) == 0) {
                    map.remove(gem);
                }
                left++;
            }
            right++;
        }
        return answer;
    }
}
