class Solution {
    public int solution(int[] number) {
        // 3명의 정수 번호 합이 0이 되는 개수
        int answer = 0;
        for(int i = 0 ; i < number.length; i++){
            for(int j = i + 1; j < number.length; j++){
                for(int k = j + 1; k < number.length; k++){
                    if(number[i] + number[j] + number[k] == 0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}