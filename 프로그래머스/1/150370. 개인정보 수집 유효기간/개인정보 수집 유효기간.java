import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        String[]to = today.split("\\.");
        int today_num = (Integer.parseInt(to[0]) * 12 * 28 )+ ( Integer.parseInt(to[1]) * 28 ) + Integer.parseInt(to[2]);


        for (String term : terms) {
            String[] str = term.split(" ");
            map.put(str[0], Integer.parseInt(str[1]));
        }
        int i = 0;
        for (String privacy : privacies) {
            i++;
            String[] key_find = privacy.split(" ");
            String[] day_find = key_find[0].split("\\.");
            int start_day = (Integer.parseInt(day_find[0]) * 12 * 28 )+ ( Integer.parseInt(day_find[1]) * 28 ) + Integer.parseInt(day_find[2]);
            int end_day = start_day + (map.get(key_find[1]) * 28);
            if(today_num >= end_day){
                list.add(i);
            }

        }


        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}