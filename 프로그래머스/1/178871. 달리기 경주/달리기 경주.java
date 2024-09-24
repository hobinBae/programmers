import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }

        for (String calling : callings) {
            map.put(players[map.get(calling) - 1], map.get(players[map.get(calling) - 1]) + 1);
            players[map.get(calling)] = players[map.get(calling) - 1];

            map.put(calling, map.get(calling) -1);
            players[map.get(calling)] = calling;
        }
       return players;
    }
}