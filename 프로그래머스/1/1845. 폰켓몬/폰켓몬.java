import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int[] unique = Arrays.stream(nums)
            .distinct()
            .toArray();
         
        return unique.length < (nums.length / 2) ? unique.length : (nums.length / 2);
    }
}