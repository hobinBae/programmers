import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <= 9; i++){
            map.put(i, 0);
        }
        
        for(int i = 0; i < numbers.length; i++){
            map.put(numbers[i], map.getOrDefault(numbers[i], 0) + 1);
        }
        
        for(int i = 0; i <= 9; i++){
            if(map.get(i) == 0){
                answer += i;
            }
        }
        return answer;
    }
}