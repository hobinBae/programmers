import java.util.*;
class Solution
{
    public int solution(String s)
    {
        // 스택 활용
        ArrayDeque<Character> dq = new ArrayDeque<>();
        int answer = 0;
        for(char c : s.toCharArray()){
            if(dq.isEmpty()){
                dq.add(c);
                continue;
            }
            
            if(dq.peekLast() == c){
                dq.pollLast();
            }else{
                dq.add(c);
            }
        }

            
        if(dq.isEmpty()){
            answer = 1;
        }
        
        return answer;
    }
}