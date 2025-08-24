class Solution {
    public int[] solution(int brown, int yellow) {
        
        int sum = brown + yellow;
        int width = 0;
        int height = 0;
        
        for(height = 1; height <= Math.sqrt(sum); height++)
        {
            if(sum % height == 0)
            {
                width = sum / height;
                
                if((width - 2) * (height - 2) == yellow)
                {
                    return new int[] {width, height};
                }
            }
        }
        
        return new int[]{};
    }
}