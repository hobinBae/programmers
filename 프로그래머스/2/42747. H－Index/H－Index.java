import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
    
        int index = 1;
        for(int i = citations.length - 1; i >= 0; i--){
            if(index <= citations[i]){
                answer = index++;
            }else{
                break;
            }
          
        }
        return answer;
    }
}