class Solution {
    public int solution(String dartResult) {
              int[] score = new int[3];
        int answer = 0;
        int index = 0;
        int now = 0;
        for(int i = 0; i < dartResult.length(); i++){

            char ch = dartResult.charAt(i);
            if(ch >= '0' && ch <= '9'){
                if( i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0'){
                    now = 10;
                    i++;
                }else{
                    now = Integer.parseInt(String.valueOf(ch));
                }
            }else{
               switch(ch){
                   case 'S' :
                       score[index++] = (int) Math.pow(now, 1);
                       break;
                   case 'D':
                       score[index++] = (int) Math.pow(now , 2);
                       break;
                   case 'T':
                       score[index++] = (int) Math.pow(now, 3);
                       break;
                   case '*' :
                       if(index - 1 != 0){
                           score[index - 1] *= 2;
                           score[index - 2] *= 2;
                       }else {
                           score[index - 1] *= 2;
                       }
                       break;
                   case '#' :
                       score[index - 1] *= -1;
                       break;
                   default :
                       break;
               }
            }

        }
        for (int i : score) {
            answer += i;
        }
        return answer;
    }
}