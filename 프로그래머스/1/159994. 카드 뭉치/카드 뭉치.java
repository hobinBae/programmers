import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
          Stack<String> card1 = new Stack<>();
        Stack<String> card2 = new Stack<>();
        int answer = 1;
        for(int i = cards1.length - 1; i >= 0; i--){
            card1.push(cards1[i]);
        }
        for(int i = cards2.length - 1; i >= 0; i--){
            card2.push(cards2[i]);
        }

        for (String s : goal) {
            if(!card1.isEmpty() && card1.peek().equals(s)){
                card1.pop();
            }else if(!card2.isEmpty() && card2.peek().equals(s)){
                card2.pop();
            }
            else{
                answer = -1;
            }

        }

        return answer == 1 ? "Yes" : "No";
    }
}