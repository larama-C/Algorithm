class Solution {
    public int solution(int[][] sizes) {
        int Width = 0;
        int Height = 0;
        
        for(int i = 0; i < sizes.length; i++)
        {
            if(sizes[i][0] < sizes[i][1])
            {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            
            if(Width < sizes[i][0])
            {
                Width = sizes[i][0];
            }
            
            if(Height < sizes[i][1])
            {
                Height = sizes[i][1];
            }
        }
        
        return Width * Height;
    }
}