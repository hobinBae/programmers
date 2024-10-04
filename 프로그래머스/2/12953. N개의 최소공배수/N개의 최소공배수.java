class Solution {
        private static int gcd(int a, int b){
        int temp = 0, r = 0;
        if(a < b){
            temp = a;
            a = b;
            b = temp;
        }

        while(b >= 1){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    private static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
    public int solution(int[] arr) {
     for(int i = 0; i < arr.length - 1; i++){
            arr[i + 1] = lcm(arr[i], arr[i + 1]);
        }
        return arr[arr.length - 1];
    }
}