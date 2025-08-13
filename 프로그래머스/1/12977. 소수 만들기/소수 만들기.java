class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                for(int k = j + 1; k < nums.length; k++)
                {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(Prime(sum)) answer++;
                }
            }
        }

        return answer;
    }
    
    public boolean Prime(int sum)
    {
        if(sum >= 2)
        {
            for(int i = 2; i * i <= sum; i++)
            {
                if(sum % i ==0)
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
        
        return true;
    }
}