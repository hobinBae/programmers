import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
         HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 6;
        int mode = 0;
        map.put(a, map.getOrDefault(a,0) + 1);
        map.put(b, map.getOrDefault(b,0) + 1);
        map.put(c, map.getOrDefault(c,0) + 1);
        map.put(d, map.getOrDefault(d,0) + 1);
        if(map.size() == 4){
            for(int i : map.keySet()){
                answer = Math.min(answer, i);
            }
        }else if(map.size() == 3){
            int [] key = new int[2];
            int index = 0;
            for(int i : map.keySet()){
                int value = map.get(i);
                if(value != 2){
                    key[index++] = i;
                }
            }
            answer = key[0] * key[1];
        }else if(map.size() == 2){
            int sum = 0;
            int [] key = new int[2];
            int index = 0;

            for(int i : map.keySet()){
                int value = map.get(i);
                key[index++] = i;
                if(value == 2){
                    sum++;
                }
            }
            if(sum != 0){
                answer = (key[0] + key[1]) * Math.abs(key[0] - key[1]);
            }else {
                for(int i : map.keySet()){
                    int value = map.get(i);
                    if(value == 3){
                        key[0] = i;
                    }else key[1] = i;
                }
                answer = (10 * key[0] + key[1]) * (10 * key[0] + key[1]);
            }
        }else
            answer = 1111 * a;


        return answer;
    }
}