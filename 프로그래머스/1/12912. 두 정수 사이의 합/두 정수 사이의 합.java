class Solution {
    public long solution(int a, int b) {
        long answer = 0;
       int nA = a < b ? a : b;
        int nB = a < b ? b : a;
        for(int i = nA; i <= nB; i++){
            answer += i;
        }
        return answer;
    }
}