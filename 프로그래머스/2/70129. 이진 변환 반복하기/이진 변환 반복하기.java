class Solution {
    public int[] solution(String s) {
        int zero = 0;
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        while(length > 1){
            if(s.contains("0")){
                s = s.replace("0", "");
            }
            zero += length - s.length();
            System.out.println(s.length());
            s = Integer.toBinaryString(s.length());
            length = s.length();
            answer++;
        }
        return new int[]{answer, zero};
    }
}