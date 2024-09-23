import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        // 필터링 및 정렬
        return Arrays.stream(data)
            .filter(arr -> arr[map.get(ext)] < val_ext)  // 필터링
            .sorted(Comparator.comparingInt(arr -> arr[map.get(sort_by)]))  // 정렬
            .toArray(int[][]::new);
    }
}