import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
            int[][] current = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] answer = new int[3];
        ArrayList<Integer>list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < current.length; i++) {
            int sum = 0;
            for (int j = 0; j < answers.length; j++) {
                if(answers[j] == current[i][j % current[i].length]){
                    sum++;
                }
            }
            answer[i] = sum;
     
            max = Math.max(max, sum);
        }
        for (int i = 0; i < answer.length; i++) {
            if(answer[i] == max){
                list.add(i + 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();


    
    }

}