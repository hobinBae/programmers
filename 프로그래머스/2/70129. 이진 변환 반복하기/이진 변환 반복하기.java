class Solution {
    static int removeCount;
    public int[] solution(String s) {
        int count = 0;
        removeCount = 0;
        while(true){
            count++;
            String now = removeZore(s);
            if(now.equals("1")){
                break;
            }
            s = numberConversion(now);
        }
        return new int[]{count, removeCount};
    }
    
    
    // 0 제거
    static String removeZore(String s){
        int sLen = s.length();
        String str = s.replaceAll("0" ,"");
        int strLen = str.length();
        int sum = sLen - strLen;
        removeCount += sum;
        return str;
    }
    
    // s 길이 진수 변환
    static String numberConversion(String s){
        return Integer.toBinaryString(s.length());
    }
}