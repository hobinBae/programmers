import java.util.*;
class Solution {
    public String[] solution(String[] record) {
         Map<String, String> map = new HashMap<>();
        int index = 0;
        for(int i = 0; i < record.length; i++){
            String[] str = record[i].split(" ");
           if(!str[0].equals("Leave"))
            map.put(str[1], str[2]);
           if(str[0].equals("Enter") || str[0].equals("Leave")){
               index++;
           }
        }
        String[] answer = new String[index];
        int idx = 0;
        for(int i = 0; i < record.length; i++){
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter")){
                answer[idx++] = map.get(str[1]) + "님이 들어왔습니다.";
            }else if(str[0].equals("Leave")){
                answer[idx++] = map.get(str[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}