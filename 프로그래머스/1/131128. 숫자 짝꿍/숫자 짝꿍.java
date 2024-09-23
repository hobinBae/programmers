import java.util.*;
class Solution {
    public String solution(String X, String Y) {
   HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char[] chX = X.toCharArray();
        for (char c : chX) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        char[] chY = Y.toCharArray();
        for (char c : chY) {
            if(map.containsKey(c) && map.get(c) > 0){
                map.put(c, map.get(c) - 1);
                sb.append(c);
            }
        }
        char[] ch = sb.toString().toCharArray();
        Arrays.sort(ch);
        sb = new StringBuilder(new String(ch)).reverse();
        
        if(sb.length() == 0){
            return "-1";
        }
        if(sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
}