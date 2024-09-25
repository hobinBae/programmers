import java.util.*;
class Solution {
    public int solution(int[] nums) {
           int a = nums.length / 2;
        int k = 0;
        Map <Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        if(a < map.size()){
            return a;
        }else return map.size();
    }
}