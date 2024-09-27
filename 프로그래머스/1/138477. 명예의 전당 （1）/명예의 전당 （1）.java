import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
 PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] answer = new int[score.length];
        int index = 0;
        for (int i : score) {
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
            answer[index++] = pq.peek();

        }
        return answer;
    }
}