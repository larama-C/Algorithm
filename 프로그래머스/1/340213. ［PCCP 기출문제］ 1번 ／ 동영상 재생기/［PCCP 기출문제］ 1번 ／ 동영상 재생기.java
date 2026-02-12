class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] t;

        t = video_len.split(":");
        int videoLen = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);

        t = pos.split(":");
        int cur = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);

        t = op_start.split(":");
        int opStart = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);

        t = op_end.split(":");
        int opEnd = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);

        if (cur >= opStart && cur <= opEnd) {
            cur = opEnd;
        }

        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                cur -= 10;
                if (cur < 0) {
                    cur = 0;
                }
            } else {
                cur += 10;
                if (cur > videoLen) {
                    cur = videoLen;
                }
            }

            if (cur >= opStart && cur <= opEnd) {
                cur = opEnd;
            }
        }

        int m = cur / 60;
        int s = cur % 60;

        return String.format("%02d:%02d", m, s);
    }
}
