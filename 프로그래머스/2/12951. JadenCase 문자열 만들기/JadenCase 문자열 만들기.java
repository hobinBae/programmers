import java.util.*;
class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        String end = s.substring(s.length()-1, s.length());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            // System.out.println(arr[i]);
            String[] arrSplit = arr[i].split("");
            StringBuilder str = new StringBuilder();
        
            for(int j = 0; j < arrSplit.length; j++){
                if(j == 0){
                    try{
                        str.append(Integer.parseInt(arrSplit[j]));
                    }catch(Exception e){
                        str.append(arrSplit[j].toUpperCase());
                    }
                    continue;
                }
                
                str.append(arrSplit[j].toLowerCase());
            }
            if(i == arr.length - 1){
                sb.append(str.toString());
            }else{
                sb.append(str.toString()).append(" ");
            }
            
            
        }
        
        return end.equals(" ") ? sb.append(end).toString() : sb.toString();
    }
}