class Solution {
    public String solution(String s, int n) {
    StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                sb.append(' ');
            } else {
                if (ch >= 97) {
                    if (ch + n > 122) {
                        sb.append((char) ((ch + n) - 26));
                    } else
                        sb.append((char) (ch + n));
                } else if (ch <= 90) {
                    if (ch + n > 90) {
                        sb.append((char) ((ch + n) - 26));
                    } else
                        sb.append((char) (ch + n));
                }
            }
        }
        return sb.toString();
    }
}