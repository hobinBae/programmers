import java.util.*;
class Solution {
    //deque 사용 
    //deque가 비어 있어면 add
    //peek를 해서 자기보다 크거나 같을 때까지 pollLast하고 add
    //add 전에 deque의 크기가 k와 같으면 안넣음
    public String solution(String number, int k) {
        String answer = "";
        
        ArrayDeque<Character> dq = new ArrayDeque<>();

        for(char c : number.toCharArray()){
            while(!dq.isEmpty() && dq.peekLast() < c && k > 0){
                dq.pollLast();
                k--;
            }
            dq.add(c);
            
        }
        // System.out.print(dq);
        if(k > 0){
            while(k > 0){
                dq.pollLast();
                k--;
            }
        }
        while(!dq.isEmpty()){
            answer += dq.poll();
        }
        return answer;
    }
}