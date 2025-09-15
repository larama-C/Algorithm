class Solution {
    int solution(int[][] land) {
        int n = land.length;

        for (int i = 1; i < n; i++) 
        {
            int[] leftMax = new int[4];
            int[] rightMax = new int[4];

            leftMax[0] = land[i-1][0];
            for (int j = 1; j < 4; j++) 
            {
                leftMax[j] = Math.max(leftMax[j-1], land[i-1][j]);
            }

            rightMax[3] = land[i-1][3];
            for (int j = 2; j >= 0; j--) 
            {
                rightMax[j] = Math.max(rightMax[j+1], land[i-1][j]);
            }

            for (int j = 0; j < 4; j++) 
            {
                int maxPrev;
                if (j == 0) maxPrev = rightMax[1];
                else if (j == 3) maxPrev = leftMax[2];
                else maxPrev = Math.max(leftMax[j-1], rightMax[j+1]);

                land[i][j] += maxPrev;
            }
        }

        int answer = 0;
        for (int j = 0; j < 4; j++) 
        {
            answer = Math.max(answer, land[n-1][j]);
        }

        return answer;
    }
}
