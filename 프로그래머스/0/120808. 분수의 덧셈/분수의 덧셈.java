class Solution {
    
    static int gdc(int a, int b){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int lcm(int a, int b){
        return a * b / gdc(a, b);
    }
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
       int[] answer = new int[2];
        int lcm = lcm(denom1, denom2);
        int a = lcm / denom1;
        int b = lcm / denom2;

        int sum = (numer1 * a) + (numer2 * b);
        int gdc = gdc(sum, lcm);

        answer[0] = sum / gdc;
        answer[1] = lcm / gdc;
       return answer;
    }
}