class Solution {
    public int solution(int[][] sizes) {
     int maxV = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;

        for (int[] size : sizes) {
            int v = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);

            maxV = Math.max(maxV, v);
            maxH = Math.max(maxH, h);
        }
        return maxV * maxH;
    }
}