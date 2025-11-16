class Solution {
    public boolean solution(int x) {
        int sum = sum(x);
        
        return x % sum == 0;
    }
    
    public static int sum(int x){
        int answer = 0;
        while(x > 0){
            int now = x % 10;
            answer += now;
            x /= 10;
        }
        return answer;
    }
}