class Solution {
    public String solution(String s) {

        String[] str = s.split(" ", -1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++){

            String[] now = str[i].split("");
            for(int j = 0; j < now.length; j++){
                String a = j % 2 == 0 ? now[j].toUpperCase() : now[j].toLowerCase();
                sb.append(a);
            }
            if(i != str.length - 1){
            sb.append(" ");    
            }
        }
        return sb.toString();
    }
}