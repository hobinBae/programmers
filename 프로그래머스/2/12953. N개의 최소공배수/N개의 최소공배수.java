class Solution {
    public int solution(int[] arr) {
    
        int lcmValue = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            lcmValue = lcm(lcmValue, arr[i]);
        }

        return lcmValue;
    }
    
    static int gcd(int a, int b){
        if(a < b){
            int t = a;
             a = b;
             b = t;
        }
        int c = 0;
        while(b > 0){
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }

}