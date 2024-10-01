import java.util.*;
class Solution {
    public int solution(int a, int b) {
      List<Integer>list = new ArrayList<>();
       int answer = 0;
        int max = 0;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                max = i;
            }
        }

        a = a / max;
        b = b / max;
        if(b == 1 && a > b){
            return 1;
        }
        for(int i = 2; i <= b; i++){
            if(b % i == 0){
                while(b % i == 0){
                    list.add(i);
                    b /= i;
                }
            }
        }
        if(list.isEmpty()){
            answer = 2;
        }else{
            for(int i : list){
                if(i == 2 || i == 5){
                    answer = 1;
                }
                else{
                    answer = 2;
                    break;
                }
            }
        }
        return answer ;
    }
}



