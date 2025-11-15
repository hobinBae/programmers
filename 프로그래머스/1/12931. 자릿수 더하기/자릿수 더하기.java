import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        //10의 나머지
        //10의 나누기를 반복해서 0보다 크면 반복
        
        while(n > 0){
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}