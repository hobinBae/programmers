import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        // 모든 배열을 정렬을 한다. 
        // 그리고 가로 세로 가장 큰 것만 선택 
        int maxW = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;
        
        for(int[] arr : sizes){
            Arrays.sort(arr);
            
            maxW = Math.max(maxW, arr[0]);
            maxH = Math.max(maxH, arr[1]);
        }
        return maxW * maxH;
    }
}