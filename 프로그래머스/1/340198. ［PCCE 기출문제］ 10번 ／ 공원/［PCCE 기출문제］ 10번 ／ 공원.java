class Solution {
    public int solution(int[] mats, String[][] park) {
       int[][] parkInt = new int[park.length][park[0].length];
        int answer = 0;
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length; j++){
                if(park[i][j].equals("-1")){
                    parkInt[i][j] = Integer.parseInt(park[i][j]) * -1;
                }
            }
        }

        for (int i = 1; i < parkInt.length; i++) {
            for (int j = 1; j < parkInt[0].length; j++) {
                if(parkInt[i][j] > 0 && parkInt[i - 1][j] > 0 && parkInt[i -1][j - 1] > 0 && parkInt[i][j - 1] > 0){
                    parkInt[i][j] += Math.min(parkInt[i - 1][j], Math.min(parkInt[i - 1][j - 1], parkInt[i][j - 1]));
                }
                for (int k = 0; k < mats.length; k++) {
                    if(parkInt[i][j] == mats[k]){
                        answer = Math.max(answer, mats[k]);
                    }
                }

            }
        }
    if(answer == 0)
        return -1;
    return answer;
    }
}