import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> scoreMap = new HashMap<>();
        for (char c : new char[]{'R','T','C','F','J','M','A','N'}) {
            scoreMap.put(c, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            int choice = choices[i];
            int diff = Math.abs(choice - 4);
            
            if (choice < 4) {
                scoreMap.put(first, scoreMap.get(first) + diff);
            } else if (choice > 4) {
                scoreMap.put(second, scoreMap.get(second) + diff);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(getType(scoreMap, 'R', 'T'));
        result.append(getType(scoreMap, 'C', 'F'));
        result.append(getType(scoreMap, 'J', 'M'));
        result.append(getType(scoreMap, 'A', 'N'));

        return result.toString();
    }

    private char getType(Map<Character, Integer> map, char a, char b) {
        int scoreA = map.get(a);
        int scoreB = map.get(b);
        if (scoreA == scoreB) return a < b ? a : b;
        return scoreA > scoreB ? a : b;
    }
}
