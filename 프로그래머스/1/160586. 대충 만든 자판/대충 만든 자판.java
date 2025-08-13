class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                int minPress = Integer.MAX_VALUE;
                
                for (int k = 0; k < keymap.length; k++) {
                    for (int l = 0; l < keymap[k].length(); l++) {
                        if (c == keymap[k].charAt(l)) {
                            minPress = Math.min(minPress, l + 1);
                        }
                    }
                }
                
                if (minPress == Integer.MAX_VALUE) {
                    sum = -1;
                    break;
                }
                
                sum += minPress;
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}
