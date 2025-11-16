class Solution {
    public int[] solution(long n) {
        String s = n + "";
        int[] answer = new int[s.length()];
        int idx = 0;
        while(n > 0){
           int now = (int) (n % 10); 
            answer[idx++] = now;
            n /= 10;
        }
        return answer;
    }
}