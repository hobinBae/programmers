import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
         Arrays.sort(score);
        int length = score.length % m;
        TreeSet<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        int size = 0;
        int sum = 0;
        for(int i = score.length - 1; i >= length; i--){
            size++;
            set.add(score[i]);
            if(size == m){
                list.add(set.first() * m);
                set.clear();
                size = 0;
            }
        }
        for (Integer i : list) {
            sum += i;

        }
        return sum;
    }
}