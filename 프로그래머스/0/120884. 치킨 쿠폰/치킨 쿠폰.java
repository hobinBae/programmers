class Solution {
    public int solution(int chicken) {
      int service = chicken / 10;
        int coupon = chicken % 10 + service;
        while(coupon >= 10){
            int temp = 0;
            service += coupon / 10;
            temp = coupon % 10;
            coupon = coupon / 10 + temp;

        }

        return service;
    }
    
    
}