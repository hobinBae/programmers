class Solution {
    public int solution(int[] common) {
         int answer = common[common.length - 1];
        if(common[1] - common[0] == common[common.length -1] - common[common.length -2]){
            answer += common[1] - common[0];
        }else if(common[1] / common[0] == common[common.length - 1] / common[common.length - 2]){
            answer *= (common[1] / common[0]);

        }
        return answer;
    }
}