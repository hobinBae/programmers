import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
      int[] answer1 = {1, 2, 3, 4, 5};
        int[] good = new int[4];
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == answer1[i % answer1.length]){
                good[1]++;
            }
            if(answers[i] == answer2[i % answer2.length]){
                good[2]++;
            }
            if(answers[i] == answer3[i % answer3.length]){
                good[3]++;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < good.length; i++){
            max = Math.max(max, good[i]);
        }

        for(int i = 0; i < good.length; i++){
            if(max == good[i]){
                list.add(i);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}