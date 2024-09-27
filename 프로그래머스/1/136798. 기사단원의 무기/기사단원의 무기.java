class Solution {
    public int solution(int number, int limit, int power) {
              int[] answer = new int[number];
        int index = 0;
        int result = 0;
        for(int i = 1; i <= number; i++){
            int sum = 0;
            for(int j = 1; j * j <= i; j++){
                if(j * j == i){
                    sum++;
                }else if(i % j == 0)
                    sum += 2;
            }
            answer[index++] = sum;

        }
        for (int i : answer) {
            if(i > limit){
                result += power;
            }else
                result += i;
        }
        return result;
    }
} 