import java.util.*;
class Solution {
    
    static class Node{
        int pri;
        int index;
        
        public Node(int pri, int index){
            this.pri = pri;
            this.index = index;
        }
    }
    
    public int solution(int[] priorities, int location) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        int answer = 0;
        int cnt = 1;
        for(int i = 0; i < priorities.length; i++){
            dq.addLast(new Node(priorities[i], i));
        }
        while(!dq.isEmpty()){
            Node tem = dq.pollFirst();
            boolean flag = false;
            for(Node i : dq){
                if(tem.pri < i.pri){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                if(tem.index == location){
                    answer = cnt;
                    break;
                }
                cnt++;
            }else{
                dq.addLast(tem);
            }
        }
        
        return answer;
    }
}