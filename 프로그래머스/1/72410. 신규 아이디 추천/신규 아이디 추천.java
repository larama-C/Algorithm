class Solution {
    public String solution(String new_id) {
        String s = new_id.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9') ||
                c == '-' || c == '_' || c == '.')
                sb.append(c);
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '.' && sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '.') {
                continue;
            }
            sb2.append(c);
        }

        if (sb2.length() > 0 && sb2.charAt(0) == '.') {
            sb2.deleteCharAt(0);
        }
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == '.') {
            sb2.deleteCharAt(sb2.length() - 1);
        }

        if (sb2.length() == 0) {
            sb2.append("a");
        }

        if (sb2.length() >= 16) {
            sb2.setLength(15);
        }
        if (sb2.charAt(sb2.length() - 1) == '.') {
            sb2.deleteCharAt(sb2.length() - 1);
        }

        while (sb2.length() < 3) {
            sb2.append(sb2.charAt(sb2.length() - 1));
        }

        return sb2.toString();
    }
}