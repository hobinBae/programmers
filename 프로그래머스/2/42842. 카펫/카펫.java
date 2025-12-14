class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        // Iterate only until sqrt(sum) for optimization
        // 합의 제곱근까지만 탐색하여 시간복잡도 최적화
        for (int height = 1; height * height <= sum; height++) {
            if (sum % height != 0) continue;

            int width = sum / height;

            // Width must be greater than or equal to height
            // 가로 길이는 세로보다 크거나 같아야 함
            if (width < height) continue;

            // Calculate brown blocks on the border
            // 테두리에 해당하는 갈색 블록 수 계산
            int border = 2 * (width + height) - 4;
            if (border != brown) continue;

            answer[0] = width;
            answer[1] = height;
            break;
        }

        return answer;
    }
}