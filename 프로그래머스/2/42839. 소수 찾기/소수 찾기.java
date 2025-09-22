import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> result = new HashSet<>();
        char[] arr = numbers.toCharArray();
        int n = arr.length;

        for (int i = 1; i < (1 << n); i++) 
        {
            List<Character> selected = new ArrayList<>();
            for (int j = 0; j < n; j++) 
            {
                if ((i & (1 << j)) != 0) selected.add(arr[j]);
            }

            List<String> perms = new ArrayList<>();
            perms.add("");

            for (char c : selected) 
            {
                List<String> temp = new ArrayList<>();
                for (String s : perms) 
                {
                    for (int k = 0; k <= s.length(); k++) 
                    {
                        String newPerm = s.substring(0, k) + c + s.substring(k);
                        temp.add(newPerm);
                    }
                }
                perms = temp;
            }

            for (String s : perms)
            {
                result.add(Integer.parseInt(s));
            }
        }

        int answer = 0;
        for (int num : result) 
        {
            if (isPrime(num))
            {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i * i <= n; i++) 
        {
            if (n % i == 0) return false;
        }
        return true;
    }
}
