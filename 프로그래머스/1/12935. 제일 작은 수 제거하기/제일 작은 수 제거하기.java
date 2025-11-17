import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            min = Math.min(arr[i], min);
        }
        int[] answer = new int[arr.length - 1];
        int idx = 0;
        for(int i : arr){
            
            if(i == min) continue;
            
            answer[idx++] = i;
        }
        
        return answer.length == 0 ? new int[] {-1} : answer;
    }
}