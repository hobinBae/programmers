import java.util.*;
class Solution {
    public int solution(String s) {
        // 길이를 2배로 늘리고 한칸씩 옆으로 가면 될 듯 
        
        int sLength = s.length();
        String rotateS = s + s;
        int answer = 0;
        System.out.println(rotateS);
        for(int i = 0; i < rotateS.length() - sLength; i++){
            // System.out.println(i);
            ArrayDeque<Character> dq = new ArrayDeque<>();
            for(int j = i; j < i + sLength; j++){
                char c = rotateS.charAt(j);

                
                if(dq.isEmpty()){
                    dq.addLast(c);
                    continue;
                }
                
                if(c == ')'){
                    if(dq.peekLast() == '('){
                        dq.pollLast();
                    }else{
                        dq.addLast(c);
                    }
                }
                
               else if(c == '}'){
                    if(dq.peekLast() == '{'){
                        dq.pollLast();
                    }else{
                        dq.addLast(c);
                    }
                }
                
               else if(c == ']'){
                     if(dq.peekLast() == '['){
                        dq.pollLast();
                    }else{
                        dq.addLast(c);
                    }
                }
              else{
                  dq.addLast(c);
              }
            }
            
            if(dq.isEmpty()){
                answer++;
            }

        }
        
        return answer;
    }
}