class Solution {
    public String solution(int n, int t, int m, int p) {
        // String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int i = 0;
        while(sb.length() != t){
            String now = Integer.toString(i++, n);
            String[] str = now.split("");
            for(int j = 0; j < str.length; j++){
                if(idx++ % m == p - 1){
                    sb.append(str[j].toUpperCase());
                }
                if(sb.length() == t){
                    break;
                }
                   
            }
            
        }
        return sb.toString();
    }

    
}