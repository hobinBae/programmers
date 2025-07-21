import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
  ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        while(idx < progresses.length){
            int count = 0;
            for(int i = 0; i < speeds.length; i++){
                progresses[i] += speeds[i];
            }
            while (progresses[idx] >= 100) {
                idx++;
                count++;
                if(idx >= progresses.length){
                    break;
                }
            }
            if(count > 0){
                list.add(count);
            }

        }

        return list.stream().mapToInt(Integer::intValue).toArray();    }
}