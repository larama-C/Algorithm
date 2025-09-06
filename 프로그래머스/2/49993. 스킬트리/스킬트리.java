import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) 
        {
            String tree = skill_trees[i];
            int idx = 0;
            boolean valid = true;

            for (int j = 0; j < tree.length(); j++) 
            {
                char c = tree.charAt(j);

                if (skill.indexOf(c) != -1) 
                {
                    if (c == skill.charAt(idx)) 
                    {
                        idx++;
                    } 
                    else 
                    {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) 
            {
                answer++;
            }
        }
        return answer;
    }
}
