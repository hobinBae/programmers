class Solution {
    public int[] solution(int num, int total) {
         int[] answer = new int[num];
        int mid = total / num;
        int firstValue = 0;

        if(num % 2 == 0){
            firstValue = mid - num / 2 + 1;
        }else{
            firstValue = mid - num / 2;
        }
        for(int i = 0; i < answer.length; i++){
            answer[i] = firstValue++;
        }
        return answer;
    }
}