class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        for (String string : str) {
            min = Math.min(min, Integer.parseInt(string));
            max = Math.max(max, Integer.parseInt(string));
        }
        return min + " " + max;
    }
}