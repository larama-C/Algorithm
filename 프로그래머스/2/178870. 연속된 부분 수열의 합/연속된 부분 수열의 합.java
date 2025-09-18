import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;

        int n = sequence.length;

        for (int i = 0, j = 0, sum = 0; i < n; i++)
        {
            if (i > 0)
            {
                sum -= sequence[i - 1];
            }
            
            while (j < n && sum < k)
            {
                sum += sequence[j];
                j++;
            }

            if (sum == k)
            {
                if (j - 1 - i < minLength)
                {
                    answer[0] = i;
                    answer[1] = j - 1;
                    minLength = j - 1 - i;
                }
            }
        }

        return answer;
    }
}
