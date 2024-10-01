class Solution {
    public int[] solution(int[][] score) {
        double[] avg = new double[score.length];
        int[] answer = new int[score.length];
        for(int i = 0; i < score.length; i++){
            avg[i] = (double)(score[i][0] + score[i][1]) / 2;
        }
        for(int i = 0; i < avg.length; i++){
            int sum = 0;
            for(int j = 0; j < avg.length; j++){
                if(avg[i] < avg[j]){
                    sum++;
                }
            }
            answer[i] = sum + 1;
        }
    return answer;
    }
}