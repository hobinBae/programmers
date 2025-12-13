class Solution {
    public String solution(String s, int n) {

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' '){
                sb.append(" ");
                continue;
            }
            if(c >= 'a' && c <= 'z'){
                c = (char)('a' + ((c - 'a' + n) % 26));
            }
            else if(c >= 'A' && c <= 'z'){
                c = (char)('A' + ((c - 'A' + n) % 26));
            }
            sb.append(c);
        }
        return sb.toString();
    }
}