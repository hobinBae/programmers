import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] people = new int[N + 2];
        for (int stage : stages) {
            people[stage]++;
        }
        double total = stages.length;
        HashMap<Integer, Double> map = new HashMap<>();
        for(int i = 1; i <= N; i++){
            if(people[i] == 0){
                map.put(i, 0.);
            }else{
                map.put(i, people[i] / total);
                total -= people[i];
            }
        }
        return map.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}