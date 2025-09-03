import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int s : scoville) 
        {
            minHeap.add(s);
        }
        
        while(minHeap.size() > 1 && minHeap.peek() < K) 
        {
            int origin = minHeap.poll();
            int next = minHeap.poll();
            minHeap.add(origin + next * 2);
            answer++;
        }
        
        return minHeap.peek() >= K ? answer : -1;
    }
}
