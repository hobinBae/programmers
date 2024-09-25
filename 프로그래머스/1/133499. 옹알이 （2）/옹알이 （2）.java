class Solution {
    public int solution(String[] babbling) {
 String[] str = {"aya", "ye", "woo", "ma"};
        String[] str2 = {"ayaaya", "yeye", "woowoo", "mama"};
        int answer = 0;
        for(int i = 0; i < babbling.length; i++){
            for(int j = 0; j < str.length; j++){
                if(babbling[i].contains(str[j]) && !babbling[i].contains(str2[j])){
                   babbling[i] = babbling[i].replace(str[j], " ");
                }
            }
        }

        for (String s : babbling) {
            if(s.trim().isEmpty()){
                answer++;
            }

        }
        return answer;
    }
}