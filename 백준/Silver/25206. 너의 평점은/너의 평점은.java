import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> grade = new HashMap<>();
        grade.put("A+" , 4.5);
        grade.put("A0", 4.0);
        grade.put("B+", 3.5);
        grade.put("B0", 3.0);
        grade.put("C+", 2.5);
        grade.put("C0", 2.0);
        grade.put("D+", 1.5);
        grade.put("D0", 1.0);
        grade.put("F", 0.0);
        double sum = 0.0;
        double num = 0;
        for(int i = 0; i < 20; i++){
            String[] str = br.readLine().split(" ");
            if (str[2].equals("P")) {
                continue;
            }
            if(grade.containsKey(str[2])){
                sum += Double.parseDouble(str[1]);
                num += Double.parseDouble(str[1]) * grade.get(str[2]);
                
            }

        }
        System.out.printf("%.6f", num / sum);

    }



}