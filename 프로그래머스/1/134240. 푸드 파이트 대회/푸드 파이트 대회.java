class Solution {
    public String solution(int[] food) {
          StringBuilder sb = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            int length = food[i] / 2;
            for(int j = 0; j < length; j++){
                sb.append(i);
            }
        }
        return sb.toString() + "0" + sb.reverse();
    }
}