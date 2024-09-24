import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        HashMap<String, int[]> map = new HashMap<>();
        map.put("N", new int[]{-1, 0});
        map.put("S", new int[]{1, 0});
        map.put("W", new int[]{0, -1});
        map.put("E", new int[]{0, 1});

        int startX = 0;
        int startY = 0;
        String[][] parkArr = new String[park.length][park[0].length()];

        for(int i = 0; i < park.length; i++){
            String[] str = park[i].split("");
            for(int j = 0; j < str.length; j++){
                parkArr[i][j] = str[j];
                if(parkArr[i][j].equals("S")){
                     startX = i;
                     startY = j;
                }
            }
        }

        for (String route : routes) {
            StringBuilder sb = new StringBuilder();
            String[] move = route.split(" ");
            String di = move[0];
            int go = Integer.parseInt(move[1]);

            int nextX = startX;
            int nextY = startY;

          for(int i = 0; i < go; i++){
                nextX += map.get(di)[0];
                nextY += map.get(di)[1];
                System.out.println(nextX + " " + nextY);
                if(nextX < 0 || nextX >= parkArr.length || nextY < 0 || nextY >= parkArr[0].length)
                    break;
                sb.append(parkArr[nextX][nextY]);
            }

            if(sb.length() == 0 || sb.toString().contains("X") || sb.length() != go){
                continue;
            }

            startX = nextX;
            startY = nextY;


        }
        int[] answer = {startX, startY};
        return answer;
    }
}