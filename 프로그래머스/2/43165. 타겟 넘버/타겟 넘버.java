class Solution {
    
    static int answer ;
    static int N;
    static int[] copy;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        N = numbers.length;
        copy = numbers;
        boolean[] isPositive = new boolean[N];
        back(0, 0, target);
        return answer;
    }
    
      static void back(int cnt, int sum, int target){
        if(cnt >= N){
            if(target == sum){
                answer++;
            }
            return;
        }

        back(cnt + 1, sum + copy[cnt], target);

        back(cnt + 1, sum - copy[cnt], target);
    }
        static int dfs(boolean[] isPositive){
        int sum = 0;
        for(int i = 0; i < N; i++){
            if(isPositive[i]){
                sum += copy[i];
            }else{
                sum -= copy[i];
            }
        }
        return sum;
    }
}