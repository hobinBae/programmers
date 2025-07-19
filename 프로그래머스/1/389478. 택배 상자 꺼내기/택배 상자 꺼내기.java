class Solution {
    public int solution(int n, int w, int num) {
       int answer = 0;
        // 택배 상자를 카운트할 변수
        int cnt = 1;

        //나머지가 있으면 한층이 더 있는 것
        int mod = (n % w == 0 ? 0 : 1);

        //총 층을 계산
        int total = (n / w) + mod;
        //배열을 생성
        int[][] arr = new int[total][w];

        int idx = 0;

        int cul = 0;
        int row = 0;
        boolean flag = false;
        while (!flag) {
            if(idx % 2 == 0){
                for (int i = 0; i < w; i++) {
                    if (cnt > n) {
                        flag = true;
                        break;
                    }
                    arr[idx][i] = cnt;
                    if (cnt == num) {
                        cul = i;
                        row = idx;
                    }
                    cnt++;

                }
            }else{
                for(int i = w - 1; i >= 0; i--){
                    if (cnt > n) {
                        flag = true;
                        break;
                    }
                    arr[idx][i] = cnt;
                    if (cnt == num) {
                        cul = i;
                        row = idx;
                    }

                    cnt++;

                }
            }
            idx++;

        }
        if (mod == 0) {
            answer = total - row;
        } else {
            for (int i = total - 1; i >= row; i--) {
                if (arr[i][cul] != 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}