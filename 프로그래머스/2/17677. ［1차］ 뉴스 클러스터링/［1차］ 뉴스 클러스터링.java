import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        int[] a = new int[26 * 26];
        int[] b = new int[26 * 26];

        for (int i = 0; i + 1 < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                a[(c1 - 'A') * 26 + (c2 - 'A')]++;
            }
        }

        for (int i = 0; i + 1 < str2.length(); i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z') {
                b[(c1 - 'A') * 26 + (c2 - 'A')]++;
            }
        }

        int inter = 0, union = 0;
        for (int i = 0; i < 26 * 26; i++) {
            inter += Math.min(a[i], b[i]);
            union += Math.max(a[i], b[i]);
        }

        if (union == 0) return 65536;

        return (int) ((double) inter / union * 65536);
    }
}