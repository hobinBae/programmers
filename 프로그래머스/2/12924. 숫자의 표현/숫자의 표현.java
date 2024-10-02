class Solution {
    public int solution(int n) {
       int answer = 0;
        for (int i = 1; i * (i + 1) / 2 <= n; i++) {
            int x = (n - i * (i - 1) / 2);
            if(x % i == 0){
                answer++;
            }
        }
        return answer;
    }
}