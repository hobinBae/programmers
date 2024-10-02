class Solution {
    public int solution(int n) {
            int answer = n;
           while(true){
            String cur = Integer.toBinaryString(answer).replace("0","");

            String next =  Integer.toBinaryString(++n).replace("0","");
            if(cur.length() == next.length()){
                break;
            }
        }
        return n;
    }
}