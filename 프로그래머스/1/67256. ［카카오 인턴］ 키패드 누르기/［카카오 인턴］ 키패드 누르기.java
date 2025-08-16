import java.util.*;

class Solution
{
    public String solution(int[] numbers, String hand)
    {
        String answer = "";

        int Rhand = -1;
        int Lhand = -2;

        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9)
            {
                answer += "R";
                Rhand = numbers[i];
            }
            else if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7)
            {
                answer += "L";
                Lhand = numbers[i];
            }
            else
            {
                Boolean rightCloser = closeRight(numbers[i], Rhand, Lhand);

                if (rightCloser == null)
                {
                    if (hand.equals("right"))
                    {
                        answer += "R";
                        Rhand = numbers[i];
                    }
                    else
                    {
                        answer += "L";
                        Lhand = numbers[i];
                    }
                }
                else if (rightCloser)
                {
                    answer += "R";
                    Rhand = numbers[i];
                }
                else
                {
                    answer += "L";
                    Lhand = numbers[i];
                }
            }
        }

        return answer;
    }

    public Boolean closeRight(int target, int Rhand, int Lhand)
    {
        int[][] map =
        {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-2, 0, -1}
        };

        int[] targetPos = new int[2];
        int[] rPos = new int[2];
        int[] lPos = new int[2];

        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                if (map[i][j] == target)
                {
                    targetPos = new int[]{i, j};
                }
                if (map[i][j] == Rhand)
                {
                    rPos = new int[]{i, j};
                }
                if (map[i][j] == Lhand)
                {
                    lPos = new int[]{i, j};
                }
            }
        }

        int rDist = Math.abs(targetPos[0] - rPos[0]) + Math.abs(targetPos[1] - rPos[1]);
        int lDist = Math.abs(targetPos[0] - lPos[0]) + Math.abs(targetPos[1] - lPos[1]);

        if (rDist < lDist)
        {
            return true;
        }
        else if (rDist > lDist)
        {
            return false;
        }
        else
        {
            return null;
        }
    }
}
