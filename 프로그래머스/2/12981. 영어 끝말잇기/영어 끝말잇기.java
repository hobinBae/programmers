import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int idx = 0;
        int turn = 0;
        int caught = 0;
        HashSet<String> set = new HashSet<>();
        char lastWord = ' ';
        while(true){
            if(idx == words.length){
                break;
            }
            char firstWord = words[idx].charAt(0);
            turn = idx % n;
            if(idx == 0){
                lastWord = words[idx].charAt(words[idx].length() - 1);
            }else{
                if(firstWord != lastWord){
                    if(idx == 0){
                        idx++;
                    }

                    return new int[] {turn + 1, (idx / n) + 1};
                }else{
                    lastWord = words[idx].charAt(words[idx].length() - 1);
                }
            }
            if(!set.add(words[idx])){
                if(idx == 0){
                        idx++;
                    }
                return new int[] {turn + 1, (idx / n) + 1};
            }
            idx++;
            
        }

        return new int[]{0, 0};
    }
}