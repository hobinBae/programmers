import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {

        HashMap<String, Integer> map = new HashMap<>();
        int[] give = new int[friends.length];
        int[] answer = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        int[][] gift = new int[friends.length][friends.length];
        for (String s : gifts) {
            String[] str = s.split(" ");
            String giver = str[0];
            String receiver = str[1];
            gift[map.get(giver)][map.get(receiver)]++;
            give[map.get(giver)]++;
            give[map.get(receiver)]--;
        }

        for (int i = 0; i < gift.length; i++) {
            for (int j = 0; j < gift[0].length; j++) {
                if(i == j)
                    continue;
                if(gift[i][j] > gift[j][i]){
                    answer[i]++;
                }else if(gift[i][j] < gift[j][i]){
                    answer[j]++;
                }else if(gift[i][j] == gift[j][i]){
                    if(give[i] == give[j]){
                        continue;
                    }
                    if(give[i] > give[j]){
                        answer[i]++;
                    }else if(give[i] < give[j]){
                        answer[j]++;
                    }
                }


            }
        }
        Arrays.sort(answer);
        return answer[answer.length -1] / 2;
    }
}