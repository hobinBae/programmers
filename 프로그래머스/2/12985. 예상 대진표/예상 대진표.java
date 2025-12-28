class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while(a > 0){
            //a가 짝수인지 확인
            if(a % 2 == 0){
                if(b == a - 1){
                    return answer;
                }
                else{
                    a /= 2;
                    b = b % 2 == 0 ? b / 2 : b / 2 + 1;
                    // System.out.println("a가 짝수일 때" + " " + a + " " + b);
                    answer++;
                }
            }
            else if(a % 2 == 1){
                if(b == a + 1){
                    return answer;
                }
                else{
                    a = a / 2 + 1;
                    b = b % 2 == 0 ? b / 2 : b / 2 + 1;
                    answer++;
                    // System.out.println("a가 홀수 일 때" + " " + a + " " + b);
                }
            }
        }

        return answer;
    }
}