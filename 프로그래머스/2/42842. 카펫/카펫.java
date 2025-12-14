class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for(int i = 1; i <= sum; i++){
            int r = 0;
            int c = 0;
            
            if(sum % i == 0){
                c = i;
                r = sum / i;
            }else{
                continue;
            }
            
            if(c < r){
                continue;
            }
            
            if(c * 2 + (r - 2) * 2 != brown){
                continue;
            }
            
            answer[0] = c;
            answer[1] = r;
            break;
            
        }
        
        
        
        return answer;
    }
}