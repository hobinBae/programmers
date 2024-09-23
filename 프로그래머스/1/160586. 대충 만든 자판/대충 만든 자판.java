import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
     int[] answer = new int[targets.length];
        HashMap<Character, Integer> key = new HashMap<>();

        for(int i = 0; i < keymap.length; i++){
            for(int j = 0; j < keymap[i].length(); j++){
                char ch = keymap[i].charAt(j);
                if(key.containsKey(ch)){
                    int number = key.get(ch);
                    key.put(ch, Math.min(number, j+1));
                }else
                    key.put(ch, j +1);
            }
        }
        int index = 0;
        for (String target : targets) {
            int count = 0;
            boolean flag = true;
            for(char cur : target.toCharArray()){
                if(key.containsKey(cur)){
                    count += key.get(cur);
                }
                else {
                    flag = false;
                    break;
                }
            }
        answer[index++] = !flag ? -1 : count;
        }


        return answer;
    }
}