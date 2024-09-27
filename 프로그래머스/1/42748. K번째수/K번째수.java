import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
       int[] answer = new int[commands.length];
        int index = 0;
        for (int[] arr : commands) {
            int[] copyArray = Arrays.copyOfRange(array, arr[0] -1, arr[1]);
            Arrays.sort(copyArray);
            answer[index++] = copyArray[arr[2] -1];
        }

        return answer;
    }
}