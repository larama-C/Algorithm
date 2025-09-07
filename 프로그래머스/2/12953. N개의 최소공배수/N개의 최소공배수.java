class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int i = 1; i < arr.length; i++) 
        {
            int a = answer, b = arr[i];
            
            while (b != 0) 
            {
                int tmp = a % b;
                a = b;
                b = tmp;
            }
            
            int gcd = a;
            answer = answer / gcd * arr[i];
        }
        return answer;
    }
}
