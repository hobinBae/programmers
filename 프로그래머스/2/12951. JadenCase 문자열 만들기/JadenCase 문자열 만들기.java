class Solution {
    public String solution(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        if(ch[0] != ' '){
            if(Character.isLowerCase(ch[0])){
                ch[0] = Character.toUpperCase(ch[0]);
            }
        }
        for(int i = 1; i < ch.length; i++){
            if(ch[i] == ' '){
                continue;
            }
            if(ch[i - 1] == ' '){
                if(Character.isLowerCase(ch[i])){
                    ch[i] = Character.toUpperCase(ch[i]);
                }
            }else
                ch[i] = Character.toLowerCase(ch[i]);
        }
        for (char c : ch) {
            sb.append(c);
        }
        return sb.toString();
    }
}