import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int num = Integer.parseInt(br.readLine());
            ArrayList<Integer>list = new ArrayList<>();
            if(num == -1){
                break;
            }
            for(int i = 2; i <= num / 2; i++){
                if(num % i == 0){
                    list.add(i);
                }
            }
            int a = list.stream().mapToInt(Integer::intValue).sum() + 1;

            if(a == num){
                System.out.print(a + " = " + "1 ");
                for (Integer i : list) {
                    System.out.print("+ " + i +" ");
                }
                System.out.println();
            }else{
                System.out.println(num + " is NOT perfect.");
            }

        }
    }
}