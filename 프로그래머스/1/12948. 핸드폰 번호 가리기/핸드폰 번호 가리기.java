class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int length = phone_number.length() - 4;
        for(int i = 0; i < length; i++){
            sb.append("*");
        }
        sb.append(phone_number.substring(length, phone_number.length()));
        return sb.toString();
    }
}