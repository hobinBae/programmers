import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
           double [] value = new double[numlist.length];
        int [] answer = new int[numlist.length];
        int index = 0;
        for(int i = 0; i < value.length; i++) {
            value[i] = numlist[i] - n;
            if(value[i] < 0){
                value[i] = Math.abs(value[i]) + 0.5;
            }

        }
        Map<Integer, Double> map = new LinkedHashMap<>();
        for(int i = 0; i < value.length; i++){
            map.put(numlist[i], value[i]);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (v1, v2) -> (map.get(v1).compareTo(map.get(v2))));
        for(int i : keys){
          answer[index++] = i;
        }

        return answer;
    }
}