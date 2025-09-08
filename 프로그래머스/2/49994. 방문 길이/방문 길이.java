import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        int answer = 0;

        for (char d : dirs.toCharArray()) 
        {
            int nx = x;
            int ny = y;
            
            if (d == 'U')
            {
                ny++;
            }
            else if (d == 'D') 
            {
                ny--;
            }
            else if (d == 'R') 
            {
                nx++;
            }
            else if (d == 'L'){
                nx--;
            }

            if (nx < -5 || nx > 5 || ny < -5 || ny > 5)
            {
                continue;
            }
            
            String path1 = x + "," + y + "," + nx + "," + ny;
            String path2 = nx + "," + ny + "," + x + "," + y;

            if (!visited.contains(path1) && !visited.contains(path2))         {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }
            x = nx;
            y = ny;
        }

        return answer;
    }
}
