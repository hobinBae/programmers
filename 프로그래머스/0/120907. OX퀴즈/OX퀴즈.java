class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            int sum = 0;
            String[] sqlit = quiz[i].split(" ");
            if(sqlit[1].equals("+")){
                sum = Integer.parseInt(sqlit[0]) + Integer.parseInt(sqlit[2]);
                if(sum == Integer.parseInt(sqlit[4])){
                    answer[i] = "O";
                }else
                    answer[i] = "X";
            }else if(sqlit[1].equals("-")){
                sum = Integer.parseInt(sqlit[0]) - Integer.parseInt(sqlit[2]);
                if(sum == Integer.parseInt(sqlit[4])){
                    answer[i] = "O";
                }else
                    answer[i] = "X";
            }
        }
        return answer;
    }
}