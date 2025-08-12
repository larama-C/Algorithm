import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == arr1[i % arr1.length]) score[0]++;
            if (answers[i] == arr2[i % arr2.length]) score[1]++;
            if (answers[i] == arr3[i % arr3.length]) score[2]++;
        }
        
        List<Integer> list = new ArrayList<>();
        int max = 0;
        
        for(int i = 0; i < score.length; i++)
        {
            if(score[i] > max)
            {
                max = score[i];
                list.clear();
                list.add(i + 1);
            }
            else if(score[i] == max)
            {
                list.add(i + 1);
            }
        }

        
        return list.stream().mapToInt(i -> i).toArray();
    }
}