import java.util.*;
class Solution {
    public int solution(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        int answer = 0;
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            Stack<Character> stack = new Stack<>();
            int pop = 0;
            for (int j = i; j < i + ch.length; j++) {

                if(stack.isEmpty() && map.containsKey(ch[j % ch.length])){
                    stack.push(ch[j % ch.length]);
                }else{
                    if(!stack.isEmpty() && map.get(stack.peek()) == ch[j % ch.length]){
                        stack.pop();
                        pop++;
                    }
                    else if(map.containsKey(ch[j % ch.length])){
                        stack.push(ch[j % ch.length]);
                    }

                }
            }
            if(pop == 0)
                continue;
            if(stack.isEmpty())
                answer++;
        }
        return answer;
    }
}