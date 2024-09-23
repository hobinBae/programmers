import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
         HashMap<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        char[] chSkip = skip.toCharArray();
        for (char c : chSkip) {
            map.put(c, 0);
        }

        for(int i = 0; i < ch.length; i++){
            for(int j = 1; j <= index; j++){
                ch[i]++;
                   if(ch[i] > 122){
                    ch[i] -= (char)26;
                }
                while(map.containsKey(ch[i])){
                    ch[i]++;
                    if(ch[i] > 122){
                    ch[i] -= (char)26;
                }
                }
               
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append(c);
        }
        return sb.toString();
    }
}