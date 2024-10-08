import java.util.*;
class Solution {
    public int solution(int[] elements) {
     Set<Integer> set = new HashSet<>();

        for(int i = 0; i < elements.length; i++){
            int sum = elements[i];
            set.add(elements[i]);
            for (int j = i + 1; j < i + elements.length; j++) {
                sum += elements[j % elements.length];
                set.add(sum);
            }
        }
        return set.size();
    }
}