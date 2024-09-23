class Solution {
     
    static double inc(int[] dot1, int[] dot2){
     
        return ((double)dot1[1] - (double)dot2[1]) / ((double)dot1[0] - (double)dot2[0]);
    }
    
    public int solution(int[][] dots) {
        int answer = 0;
         if(inc(dots[0], dots[1]) == inc(dots[2], dots[3])) answer = 1;
        if(inc(dots[0],dots[2]) == inc(dots[1], dots[3])) answer = 1;
        if(inc(dots[0], dots[3]) == inc(dots[1], dots[2])) answer = 1;
        return answer;
    }
}