import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
  int[] answer = new int[n];
        int sum = 0;
        Arrays.fill(answer, 1);
        for (int i : lost) {
            answer[i - 1]--;
        }
        for (int i : reserve) {
            answer[i - 1]++;
        }

        for(int i = 0; i < answer.length; i++){
            if(answer[i] == 0){
                if(i > 0 && answer[i - 1] == 2){
                    answer[i]++;
                    answer[i - 1]--;
                }else if(i < n - 1 && answer[i + 1] == 2){
                    answer[i]++;
                    answer[i + 1]--;
                }
            }
        }
        for (int i : answer) {
            if(i > 0){
                sum++;
            }
        }
return sum;
    }
}