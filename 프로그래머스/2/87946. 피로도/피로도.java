import java.util.*;
class Solution {
  
    static int N;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        answer = Integer.MIN_VALUE;
        boolean[] used = new boolean[N];
        int[] arr = new int[N];
        per( 0, used, arr, dungeons, k);
        return answer;
    }
    static void per(int cnt, boolean[] used, int[] arr, int[][] dungeons, int k){
        if(cnt >= N){

            answer = Math.max(answer, find(arr, dungeons, k));
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(!used[i]){
                used[i] = true;
                arr[i] = cnt;
                per(cnt + 1, used, arr, dungeons, k);
                used[i] = false;
            }
        }
       
        
    }
    
    static int find(int[] arr, int[][] dungeons, int k){
        int sum = 0;
        
        for(int i = 0; i < N; i++){
            if(k >= dungeons[arr[i]][0]){
                k -= dungeons[arr[i]][1];
                sum++;
            }
        }
        return sum;
    }
}