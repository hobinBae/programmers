import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        List<Integer> list = new ArrayList<>();
        int a = brown + yellow;
        int b = brown / 2 + 2;
        int[] answer = new int[2];

        for(int i = b - 3; i >= 1; i--){
            if(i >= b - i)
                list.add(i);
        }

        for(int i = 0; i < list.size(); i++){
            int sum = (list.get(i) - 2) * ((b - list.get(i)) - 2);
            if(sum == yellow){
                answer[0] = list.get(i);
                answer[1] = b - list.get(i);
                break;
            }
        }

        return answer;

    }
}