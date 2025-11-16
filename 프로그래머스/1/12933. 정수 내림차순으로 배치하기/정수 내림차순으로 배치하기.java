import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        while(n > 0){
            Long now = n % 10;
            pq.add(now);
            n /= 10;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            sb.append(pq.poll());
}
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}