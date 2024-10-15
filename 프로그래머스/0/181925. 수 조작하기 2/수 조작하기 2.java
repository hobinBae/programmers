class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int index = numLog[0];
        String result = "";
        for(int i = 1; i < numLog.length; i++){
            if(numLog[i] == index + 1){
                result += "w";
            }
            else if(numLog[i] == index + 10){
                result += "d";
            }
            else if(numLog[i] == index - 1){
                result += "s";
            }
            else if(numLog[i] == index - 10){
                result += "a";
            }
            else continue;
          index = numLog[i];
        }
        return result;
        
        
    }
}