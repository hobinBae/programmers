class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if ( Character.isLetterOrDigit(ch) || ch == '-' || ch == '_' || ch == '.')
                sb.append(Character.toLowerCase(ch));
        }


        while(sb.indexOf("..") != -1){
             sb = new StringBuilder(sb.toString().replace(".." , "."));
        }

        if(sb.length() > 0 && sb.charAt(0) == '.')
            sb.deleteCharAt(0);
        if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '.'){
            sb.deleteCharAt(sb.length() - 1);
        }

        if(sb.length() > 15){
           sb.setLength(15);
            if(sb.toString().charAt(sb.length() - 1) == '.')
                sb.deleteCharAt(sb.length() - 1);
        }

        if(sb.length() == 0){
            sb.append("a");
        }
        if(sb.length() <= 2) {
            char last = sb.charAt(sb.length() - 1);
            while(sb.length() < 3){
                sb.append(last);
            }
        }

        return sb.toString();
    }
}