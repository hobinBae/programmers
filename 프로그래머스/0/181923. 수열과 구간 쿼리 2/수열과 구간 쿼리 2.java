class Solution {
    public int[] solution(int[] arr, int[][] queries) {
   int[] answer = new int[queries.length];
        int idx = 0;
        for(int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int value = queries[i][2];
            int max = 0;
            int min = Integer.MAX_VALUE;
            boolean f = false;
            for(int j = start; j <= end; j++){
                if(value < arr[j]){
                    max = arr[j];
                    min = Math.min(min, max);
                    f = true;
                }
            }
            if(f){
                answer[idx++] = min;
            }else{
                answer[idx++] = -1;
            }

        }
        return answer;
 }    
}
