class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] str = new String[n];
        for(int i = 0; i < arr1.length; i++){
            str[i] = String.format("%" +  n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));
            str[i] = str[i].replace("1", "#").replace("0", " ");

        }
        return str;
    }
}