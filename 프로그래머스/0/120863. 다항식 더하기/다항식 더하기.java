import java.util.*;
class Solution {
    public String solution(String polynomial) {
   String[] str = polynomial.split(" ");
        List<Integer>list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int sumX = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].contains("x")) {
                if(str[i].equals("x")){
                    list.add(Integer.parseInt( str[i].replace("x", "1")));
                }else {
                    list.add(Integer.parseInt(str[i].replace("x", "")));
                }
            }
            else{
                if(!str[i].equals("+")){
                    sum += Integer.parseInt(str[i]);
                }
            }
        }
        for(int i : list){
            sumX += i;

        }
        if(sumX != 0 && sum != 0 ){
            if(sumX == 1){
                sb.append("x ").append("+ ").append(sum);
            }else
            sb.append(sumX).append("x ").append("+ ").append(sum);
        }else{
            if(sumX == 0 && sum != 0){
                sb.append(sum);
            }
            else if(sumX !=0 && sum ==0){
                if(sumX == 1){
                    sb.append("x");
                }else
                 sb.append(sumX).append("x");
            }
        }
        return sb.toString();
    }
}