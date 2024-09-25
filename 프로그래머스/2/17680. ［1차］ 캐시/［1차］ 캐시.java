import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
ArrayDeque<String> cache = new ArrayDeque<>();
       int answer = 0;
        for(String c : cities){
           c =  c.toLowerCase();
           if(cache.contains(c)){
               cache.remove(c);
               cache.addLast(c);
               answer += 1;
           }else{
               answer += 5;
               cache.addLast(c);
               if(cache.size() > cacheSize){
                   cache.pollFirst();
               }
           }
        }
return answer;
    }
}