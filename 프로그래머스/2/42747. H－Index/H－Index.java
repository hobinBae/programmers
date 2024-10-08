import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int[] arr = new int[citations.length];
        for(int i = 0; i < citations.length; i++){
            int max = 0;
            for(int j = 0; j < citations.length; j++){
                if(citations[i] <= citations[j]){
                    max++;
                }
            }
            arr[i] = Math.min(citations[i], max);

        }
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}