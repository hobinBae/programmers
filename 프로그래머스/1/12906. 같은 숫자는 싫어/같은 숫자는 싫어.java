import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            
            if(list.isEmpty()){
                list.add(arr[i]);
                continue;
            }
             
            if(list.get(list.size() - 1) == arr[i]){
                continue;
            }

            
            list.add(arr[i]);

    }
        int length = list.size();
        int[] answer = new int[length];
        for(int i = 0 ; i < list.size(); i++){
            answer[i] = list.get(i);
        }

    return answer;
    }
}