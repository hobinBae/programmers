import java.util.*;
class Solution {
    public int[] solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        int idx = 0;
        for(char c : s.toCharArray()){
            if(map.get(c) == null){
                answer[idx] = -1;
                map.put(c,idx++);
            }else{
                int diff = idx - map.get(c);
                answer[idx] = diff;
                map.put(c, idx++);
            }
        }
        
        return answer;
    }
}