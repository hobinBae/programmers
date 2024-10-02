import java.util.*;
class Solution
{
    public int solution(String s)
    {
        ArrayDeque<Character> queue = new ArrayDeque<>();

        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (queue.isEmpty()) {
                queue.addFirst(c);
                continue;
            }
            if (queue.peek() == c) {
                queue.pollFirst();
            } else if (queue.peek() != c) {
                queue.addFirst(c);
            }
        }

        return queue.isEmpty() ? 1 : 0;
    }
}