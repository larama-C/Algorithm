import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        List<Character> list = new ArrayList<>();
        
        for (int i = 0; i < skip.length(); i++) {
            list.add(skip.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            c = AddString(c, index, list);
            answer.append(c);
        }

        return answer.toString();
    }
    
    public char AddString(char c, int index, List<Character> list)
    {
        for (int i = 0; i < index; i++) {
            c++;
            if (c > 'z') c = 'a';
            while (list.contains(c)) {
                c++;
                if (c > 'z') c = 'a';
            }
        }
        return c;
    }
}