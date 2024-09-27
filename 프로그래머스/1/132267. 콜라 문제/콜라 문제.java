class Solution {
    public int solution(int a, int b, int n) {
         int get = 0;
        while(n >= a){
            get += (n / a) * b;
            n = (n % a) + (n / a) * b;
        }
        return get;
    }
}