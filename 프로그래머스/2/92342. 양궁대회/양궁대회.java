class Solution {
    int maxDiff = -1;
    int[] answer = new int[11];

    public int[] solution(int n, int[] info) {
        dfs(0, n, new int[11], info);
        if (maxDiff == -1) return new int[]{-1};
        return answer;
    }

    void dfs(int idx, int arrows, int[] lion, int[] info) {
        if (idx == 11) {
            if (arrows > 0) lion[10] += arrows;

            int lionScore = 0, apeachScore = 0;

            for (int i = 0; i < 11; i++) {
                if (lion[i] == 0 && info[i] == 0) continue;
                if (lion[i] > info[i]) lionScore += (10 - i);
                else apeachScore += (10 - i);
            }

            int diff = lionScore - apeachScore;

            if (diff > 0) {
                if (diff > maxDiff) {
                    maxDiff = diff;
                    answer = lion.clone();
                } else if (diff == maxDiff) {
                    for (int i = 10; i >= 0; i--) {
                        if (lion[i] != answer[i]) {
                            if (lion[i] > answer[i]) {
                                answer = lion.clone();
                            }
                            break;
                        }
                    }
                }
            }

            if (arrows > 0) lion[10] -= arrows;
            return;
        }

        int need = info[idx] + 1;

        if (arrows >= need) {
            lion[idx] = need;
            dfs(idx + 1, arrows - need, lion, info);
            lion[idx] = 0;
        }

        dfs(idx + 1, arrows, lion, info);
    }
}