import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        int sum = 0;
        for(int i = 0; i < words.length; i++){
            if(i % n == 0){
                System.out.print(i);
                sum++;
            }
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            if(map.get(words[i]) > 1){
                answer = i % n + 1;
                break;
            }
            if(i != 0){
                String[] str = words[i - 1].split("");
                String[] str2 = words[i].split("");
                if(!str[str.length - 1].equals(str2[0])){
                    return new int[]{i % n + 1, sum};
                }
            }
            
        }

        if(answer == 0){
            return new int[]{0, 0};
}
        return new int[]{answer, sum};
    }
}