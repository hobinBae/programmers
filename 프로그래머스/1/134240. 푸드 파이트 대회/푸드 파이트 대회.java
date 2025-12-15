class Solution {
    
     static StringBuilder sb = new StringBuilder();
    
    public String solution(int[] food) {
        
        for(int i = 1; i < food.length; i++){
            
            if(food[i] == 1){
                continue;
            }
            
            if(food[i] % 2 == 0){
                addFood(food[i] / 2, i + "");
            }
            else{
                addFood((food[i] - 1) / 2, i + "");
            }
        }
        String answer = sb.toString();
        answer += "0";
        answer += sb.reverse();
        
        return answer;
    }
    
    static void addFood(int n, String k){
        for(int i = 0; i < n ; i++){
            sb.append(k);
        }
    }
    
}