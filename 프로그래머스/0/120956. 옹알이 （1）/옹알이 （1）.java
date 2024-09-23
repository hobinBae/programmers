class Solution {
    public int solution(String[] babbling) {
          int answer = 0;
        String[] sp = {"aya", "ye", "woo", "ma"};
        for(int i = 0; i < babbling.length; i++){
            for(int j = 0; j < sp.length; j++){
                if(babbling[i].contains(sp[j])){
                    babbling[i] = babbling[i].replaceAll(sp[j], " ");
                }
            }
            if(babbling[i].trim().isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}