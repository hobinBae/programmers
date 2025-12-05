import java.util.*;
class Solution {
    
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        
        for(int i : d){
            if(budget - i >= 0){
                budget -= i;
                count++;
            }else{
                break;
            }
                
        }
        
        return count;
    }

}