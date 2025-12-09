class Solution {
    public int solution(int n) {
        int answer = 0;
        int next = n + 1;
        while(true){
            
            String nowBinary = Integer.toBinaryString(n);
            String nextBinary = Integer.toBinaryString(next);

            if(checkBinary(nowBinary, nextBinary)){
                answer = next;
                break;
            }
            
            next++;
        }
        return answer;
    }
    
    // 이진수 확인 
    private static boolean checkBinary(String nowBinary, String nextBinary){
        int now = 0;
        int next = 0;
        
        for(int i = 0; i < nowBinary.length(); i++){
            char c = nowBinary.charAt(i);
            if(c == '1'){
                now++;
            }
        }
        
            
        for(int i = 0; i < nextBinary.length(); i++){
            char c = nextBinary.charAt(i);
            if(c == '1'){
                next++;
            }
        }
        return now == next;
    }
}