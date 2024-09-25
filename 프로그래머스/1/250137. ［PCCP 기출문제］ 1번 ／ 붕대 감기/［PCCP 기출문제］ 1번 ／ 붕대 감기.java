class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int T = 0;
        int X = bandage[1];
        int Y = bandage[2];
        int N = attacks[attacks.length - 1][0];
        int max = health;
        for(int i = 1; i <= N; i++){
            System.out.println(i);

            boolean damage = false;
            for (int[] attack : attacks) {
                 if(i == attack[0]){
                     damage = true;
                     T = 0;
                     health -= attack[1];
                     if(health <= 0)
                         return -1;
                 }
            }

            if(!damage && health < max ){
                    health += X;
                    T++;
                    if(T == bandage[0]){
                        health += Y;
                        T = 0;
                    }
                         if(health > max){
                            int over = health - max;
                            health -= over;
                        }
            }else if(!damage && health == max){
                   T++;
                  if(T == bandage[0]){
                       T = 0;
                   }
            }

        }
        return health;
    }
}