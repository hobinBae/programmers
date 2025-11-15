import java.util.*;
class Solution {
    public long[] solution(int x, int n) {
        
        List <Long> list = new ArrayList<>();
        
        list.add((long)x);
        
        for(int i = 1; i < n; i++){
            list.add(list.get(i - 1) + x);
        }
        
        return list.stream().mapToLong(Long::longValue).toArray();
    }
}