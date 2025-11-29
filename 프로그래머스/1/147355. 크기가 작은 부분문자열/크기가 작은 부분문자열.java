class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long pInt = Long.parseLong(p);
        int pLen = p.length();

        
        for(int i = 0; i < t.length() - pLen + 1; i++){
            long now = Long.parseLong(t.substring(i, i + pLen));
            if(pInt >= now) answer++;

        }
        
        return answer;
    }
}