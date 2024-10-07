import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
      HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }


        ArrayList<Integer> key = new ArrayList<>(map.keySet());
        key.sort((o1, o2) -> Integer.compare(map.get(o2), map.get(o1)));
        for (Integer i : key) {
            if(k > 0){
                k -= map.get(i);
                answer++;
            }
        }

        return answer;
    }
}