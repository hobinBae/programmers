import java.util.HashSet;
class Solution {
    public String solution(int[] numbers, String hand) {
        HashSet<Integer> l = new HashSet<>();
        l.add(1);
        l.add(4);
        l.add(7);
        HashSet<Integer> r = new HashSet<>();
        r.add(3);
        r.add(6);
        r.add(9);
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        for (int i : numbers) {
            if(l.contains(i)){
                left = i;
                sb.append("L");
            }else if(r.contains(i)){
                right = i;
                sb.append("R");
            }else {
                if(i == 0){
                    i = 11;
                }
                int midL = Math.abs(i - left) / 3 + Math.abs(i - left) % 3;
                int midR = Math.abs(i - right) / 3 + Math.abs(i - right) % 3;
                if(midL < midR){
                    sb.append("L");
                    left = i;
                }else if(midL > midR){
                    sb.append("R");
                    right = i;
                }else{
                    if(hand.equals("right")){
                        sb.append("R");
                        right = i;
                    }else{
                        sb.append("L");
                        left = i;
                    }
                }
            }
        }
        return sb.toString();
    }
}