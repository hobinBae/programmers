import java.util.*;
class Solution {
    
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 1);
        map.put('R', 2);
        map.put('L', 3);
        
        int[][] arr = new int[11][11];
        
        int startY = 5;
        int startX = 5;
        
        for(int i = 0; i < dirs.length(); i++){
            char now = dirs.charAt(i);
            
            int ny = startY + dy[map.get(now)];
            int nx = startX + dx[map.get(now)];

            if(ny >= 11 || nx >= 11 || ny < 0 || nx < 0){
                continue;
            }
            
            set.add(startY + "," + startX + "," + ny + "," + nx);
            set.add(ny + "," + nx + "," + startY + "," + startX);
            
            startY = ny;
            startX = nx;
            
        }

        
        return set.size() / 2;
    }
}