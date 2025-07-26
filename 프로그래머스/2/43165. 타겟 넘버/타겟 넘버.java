class Solution {
    
    static int answer ;
    static int N;
    static int[] copy;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        N = numbers.length;
        copy = numbers;
        boolean[] used = new boolean[N];
        back(0, used, target);
        return answer;
    }
    
      static void back(int cnt, boolean[] used, int target){
        if(cnt >= N){
            if(target == bfs(used)){
                answer++;
            }
            return;
        }
        used[cnt] = true;
        back(cnt + 1, used, target);
        used[cnt] = false;
        back(cnt + 1, used, target);
    }
        static int bfs(boolean[] used){
        int sum = 0;
        for(int i = 0; i < N; i++){
            if(used[i]){
                sum += copy[i];
            }else{
                sum -= copy[i];
            }
        }
        return sum;
    }
}