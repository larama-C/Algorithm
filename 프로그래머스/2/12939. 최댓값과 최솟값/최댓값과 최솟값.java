import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        
        Arrays.sort(arr, Comparator.comparingInt(Integer::parseInt));
        
        answer = arr[0] + " " + arr[arr.length-1];
        
        return answer;
    }
}