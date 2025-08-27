class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a != b)
        {
            a = (a % 2 == 0) ? (a / 2) : ((a + 1) / 2);
            b = (b % 2 == 0) ? (b / 2) : ((b + 1) / 2);
            answer++;
        }

        return answer;
    }
}