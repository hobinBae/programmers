class Solution {
    public String solution(String code) {
       String ret = "";
        int mode = 0;
        String[] arr = code.split("");
        for(int i = 0; i < arr.length; i++){
            if(mode == 0 && arr[i].equals("1")){
                mode = 1;
            }
            else if(mode == 1 && arr[i].equals("1")){
                mode = 0;
            }
            if(mode == 0 && ! arr[i].equals("1")){
                if(i == 0 || i % 2 == 0)
                    ret += arr[i];
            }
            if(mode == 1 && ! arr[i].equals("1")){
                if(i % 2 != 0){
                    ret += arr[i];
                }
            }

        }
       if("".equals(ret)){
           return "EMPTY";
       }
        else return ret;
        
    }
}