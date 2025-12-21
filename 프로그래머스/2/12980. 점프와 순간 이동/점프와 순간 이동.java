import java.util.*;

public class Solution {
    public int solution(int n) {
        String bit = Integer.toString(n, 2);
        int answer = 0;
        for(int i = 0; i < bit.length(); i++){
            if(bit.charAt(i) == '1'){
                answer++;
            }
        }

        return answer;
    }
}