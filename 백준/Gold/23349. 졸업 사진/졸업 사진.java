import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static class Time{
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int maxStart = 0;
    static int maxEnd = 0;

    static int maxCount = Integer.MIN_VALUE;

    static String maxPlace = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, List<Time>>map = new HashMap<>();

        Set<String> set = new HashSet<>();
        //저장할 때 이름 중복 체크 해야함
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            if(set.isEmpty()){
                set.add(name);
            }else{
                if(set.contains(name)){
                   continue;
                }else{
                    set.add(name);
                }
            }

            String place = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (map.containsKey(place)) {
                map.get(place).add(new Time(start, end));
            }else{
                List<Time> list = new ArrayList<>();
                list.add(new Time(start, end));
                map.put(place, list);
            }

        }


        //이제 겹치는 구간 체크를 해야함
        for (String place : map.keySet()) {
            List<Time> list = map.get(place);
            int endTime = 0;

            for (Time time : list) {
                endTime = Math.max(time.end, endTime);
            }
            int[] timeArr = new int[endTime + 1];

            int[] arr = new int[endTime + 1];

            for (Time time : list) {
                arr[time.start] += 1;
                arr[time.end] -= 1;
            }

            //누적합을 통한 구간 마다 최댓값 탐색
            int max = Integer.MIN_VALUE;
            int start = 0;
            int end = 0;
            for(int i = 1; i <= endTime; i++){
                //일단 누적합을 통해 계산
                timeArr[i] += timeArr[i - 1] + arr[i];
                max = Math.max(timeArr[i], max);
            }

            for(int i = 1; i <= endTime; i++){
                if(timeArr[i - 1] < max && timeArr[i] == max){
                    start = i;
                }
                if(timeArr[i - 1] == max && timeArr[i] < max){
                    end = i;
                    break;
                }
            }


            if(maxCount < max){
                maxPlace = place;
                maxStart = start;
                maxEnd = end;
                maxCount = max;
            }else if(maxCount ==  max){
                if(place.compareTo(maxPlace) < 0){
                    maxPlace = place;
                    maxStart = start;
                    maxEnd = end;
                }
            }


//            System.out.println(place + " " + Arrays.toString(arr) + " start " + start + " end " + end + " max " + max);
        }

        System.out.println(maxPlace + " " + maxStart + " " + maxEnd);
    }
}
