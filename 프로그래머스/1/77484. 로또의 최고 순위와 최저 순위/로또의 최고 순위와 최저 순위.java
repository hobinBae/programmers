import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(6, 1);
        map.put(5, 2);
        map.put(4, 3);
        map.put(3, 4);
        map.put(2, 5);
        int[] answer = new int[2];
        int min = 0;
        int max = 0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    max++;
                }
            }
            if (lottos[i] == 0) {
                max++;
            }
        }
        if (map.containsKey(max)) {
            answer[0] = map.get(max);
        } else {
            answer[0] = 6;
        }
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    min++;
                }

            }
        }

        if(map.containsKey(min)){
            answer[1] = map.get(min);
        }else
            answer[1] = 6;
    return answer;
    }
}