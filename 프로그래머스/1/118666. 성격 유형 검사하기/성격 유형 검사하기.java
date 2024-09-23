import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer>map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        String[] rcja = {"R", "C", "J", "A"};
        String[] tfmn = {"T", "F", "M", "N"};
        for(int i = 0; i < survey.length; i++){
            String[] str = survey[i].split("");
            if(choices[i] < 4){
                map.put(str[0], map.get(str[0]) +Math.abs( choices[i] - 4));
            }else
                map.put(str[1], map.get(str[1]) + choices[i] % 4);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < rcja.length; i++){
            if(map.get(rcja[i]) > map.get(tfmn[i])){
                sb.append(rcja[i]);
            }else if(map.get(rcja[i]) < map.get(tfmn[i])){
                sb.append(tfmn[i]);
            }else{
           sb.append(rcja[i]);

            }
        }
        return sb.toString();
    }
}