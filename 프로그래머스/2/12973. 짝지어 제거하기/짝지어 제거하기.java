import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == c) {
                stack.pop();
            } else if (stack.peek() != c) {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}