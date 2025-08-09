class Solution {
    public String solution(int[] food) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for(int i = 1; i < food.length; i++)
        {
            if(food[i] % 2 == 0)
            {
                for(int j = 0; j < food[i] / 2; j++)
                {
                    sb1.append(i);
                    sb2.append(i);
                }
            }
            else
            {
                for(int j = 0; j < (food[i] - 1) / 2; j++)
                {
                    sb1.append(i);
                    sb2.append(i);
                }
            }
        }
        
        sb2.reverse();
        sb1.append(0);
        sb1.append(sb2);
        
        return sb1.toString();
    }
}