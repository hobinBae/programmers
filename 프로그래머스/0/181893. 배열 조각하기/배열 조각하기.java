import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            list.add(i);
        }

        for(int i = 0; i < query.length; i++){
            int size = list.size();
            if(i % 2 == 0){
               for(int j = 0; j < size - query[i] -1; j++){
                  list.remove(list.size() - 1);
               }
            }
            else if(i % 2 == 1){
               for(int j = 0; j < query[i]; j++){
                   list.remove(0);
               }
            }
        }
        int[] answer = new int[list.size()];
        int index = 0;
        for(int i : list){
            answer[index++] = i;
        }

        return answer;

    }
}