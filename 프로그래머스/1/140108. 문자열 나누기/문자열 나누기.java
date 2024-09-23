class Solution {
    public int solution(String s) {
         char first = s.charAt(0);
        int a = 0;
        int b = 0;
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            if(first == s.charAt(i)){
                a++;
            }else
                b++;
            if(a == b && i + 1 < s.length()){
                a = 0;
                b = 0;
                first = s.charAt(i + 1);
                answer++;
            }else if(a == b && i + 1 == s.length()){
                answer++;
            }
            if(a != b && i + 1 == s.length()){
                answer++;
            }
        }
        return answer;
    }
}