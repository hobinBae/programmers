import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    /*
    N개의 수업이 주어지는데 최소의 강의실을 사용해서 모든 수업을 가능하게 해야함
    1 ~ 3
    2 ~ 4
    3 ~ 5
    강의 시간은 의미 없음

    강의가 시작하는 시간은 강의가 끝나는 시간과 같거나 커야함
     */

    static class Node{
        int s;
        int t;

        public Node(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> classrooms = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
        List<Node> lectures = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            lectures.add(new Node(s, t));
        }

        Collections.sort(lectures, (o1, o2) -> Integer.compare(o1.s, o2.s));
        for (Node lecture : lectures) {

            if(classrooms.isEmpty()){
                classrooms.add(lecture.t);
                continue;
            }

            if(classrooms.peek() <= lecture.s){
                classrooms.poll();
                classrooms.add(lecture.t);
            }else{
                classrooms.add(lecture.t);
            }
        }

        System.out.println(classrooms.size());




    }
}
