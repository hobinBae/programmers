import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> w = new HashMap<>();
        HashMap<String, Integer> d = new HashMap<>();
        
        int answer = 0;
        for(int i = 0; i < want.length; i++){
            w.put(want[i], number[i]);
        }
        
        for(int i = 0; i < 10; i++){
            d.put(discount[i], d.getOrDefault(discount[i], 0) + 1);
}
        if(valid(w, d, want)){
            answer++;
        }
        for(int i = 10; i < discount.length; i++){
            d.put(discount[i - 10], d.get(discount[i - 10]) - 1); 
            d.put(discount[i], d.getOrDefault(discount[i], 0) + 1);
            if(valid(w, d, want)){
                answer++;
            }
        }
        return answer;
    }
    private static boolean valid(HashMap<String, Integer> w, HashMap<String, Integer> d, String[] want){
        for(String s : want){
            if(d.getOrDefault(s, 0) < w.get(s))
                return false;
        }
        return true;
    }
}