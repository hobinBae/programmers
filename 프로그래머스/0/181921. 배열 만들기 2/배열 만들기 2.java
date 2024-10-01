
class Solution {
    public int[] solution(int l, int r) {
        String bit = "";
        String an = "";
        int[] no = {-1};
        for (int i = 0; i <= 63; i++) {
            bit += Integer.toBinaryString(i) + ",";
        }
        String[] bitt = bit.split(",");
        int[] bitA = new int[bitt.length];
        for (int i = 0; i < bitA.length; i++) {
            bitA[i] = Integer.parseInt(bitt[i]);

        }
        
       for (int i = 0; i < bitA.length; i++) {
            for (int j = l; j <= r; j++) {
                if (j % 5 == 0) {
                    if (j / 5 == bitA[i]) {
                        an += j + ",";
                    } 
                }
            }
        }
        if(an.isEmpty()){
            return no;
        }
        String[] ann = an.split(",");
        int[] answer = new int[ann.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(ann[i]);
            System.out.println(answer[i]);
        }
    
       return answer;
    }
} 
        