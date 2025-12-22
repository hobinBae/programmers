import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        char lastWord = words[0].charAt(words[0].length() - 1);
        
        for(int i = 1; i < words.length; i++){
            char firstWord = words[i].charAt(0);
            if(firstWord != lastWord){
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            
            if(!set.add(words[i])){
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            
            lastWord = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0, 0};
    }
}