import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
   HashSet<String>usedWords = new HashSet<>();
        char end = ' ';
        for(int i = 0; i < words.length; i++){
            if(usedWords.isEmpty()){
                usedWords.add(words[i]);
                end = words[i].charAt(words[i].length()-1);
                continue;
            }

            if(usedWords.contains(words[i]) || end != words[i].charAt(0)){
                return new int[]{(i % n) + 1, i / n + 1};
            }else{
                usedWords.add(words[i]);
                end = words[i].charAt(words[i].length() - 1);
            }

        }
        return new int[]{0, 0};
    }
    
}