import java.util.*;
class Solution
{
    public int solution(String s)
    {
        // 스택 활용
        ArrayDeque<Character> dq = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            
            if(!dq.isEmpty() && dq.peek() == c){
                dq.pop();
            }else{
                dq.push(c);
            }
        }

            

        return dq.isEmpty() ? 1 : 0;
    }
}