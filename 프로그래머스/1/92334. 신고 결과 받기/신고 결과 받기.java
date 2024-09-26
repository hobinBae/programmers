import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        List<String> list = new ArrayList<>();
        int[] answer =  new int[id_list.length];
        for (String s : id_list) {
            count.put(s, k);
            map.put(s, new HashSet<>());
        }

        for (String s : report) {
            String[] str = s.split(" ");
            map.get(str[0]).add(str[1]);
        }

        for (String s : map.keySet()) {
            for (String string : map.get(s)) {
                if (count.containsKey(string)) {
                    count.put(string, count.get(string) - 1);
                }
            }
        }
        for (String s : count.keySet()) {
          if(count.get(s) <= 0){
              list.add(s);
          }
        }

        for(int i = 0 ; i < id_list.length; i++){
            int sum = 0;
            for (String s : list) {
                if(map.get(id_list[i]).contains(s)){
                    sum++;
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}
    
