class Solution {
    public int[] solution(String s) {
             int[] answer = new int[s.length()];
        String[] str = s.split("");
        answer[0] = -1;
        for(int i = 1; i < s.length() ; i++){
            String split = s.substring(0, i);
            if(split.contains(str[i])){
                answer[i] = i - split.lastIndexOf(str[i]);
            }else
                answer[i] = -1;

        }
        return answer;
    }
}