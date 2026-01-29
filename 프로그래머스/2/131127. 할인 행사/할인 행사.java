import java.util.*;
class Solution {
    /*
    discount의 최대 크기는 100,000
    want, number의 길이는 최대 10
    그래서 10,000,000 이라 시간은 터지지 않을듯
    
    해시맵을 이용해서 인덱스를 저장
    반복문을 돌면서 해당 인덱스에 ++
    반복문을 다 돌면 해당 인덱스의 크기를 비교
    같거나 크다면 다음으로 
    작으면 break
    
    성공 여부에 따른 boolean을 만들고 성공하면 인덱스 저장
    실패하면 false

    인덱스 크기만큼
    */
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            map.put(want[i], i);
        }
        int length = 0;
        for(int i = 0; i < number.length; i++){
            length += number[i];
        }
        for(int i = 0; i <= discount.length - length; i++){
            boolean flag = true;
            int[] arr = new int[want.length];
            
            for(int j = i; j < i + length; j++){
                if(map.containsKey(discount[j])){
                    arr[map.get(discount[j])]++;
                }
            }

            for(int j = 0; j < arr.length; j++){
                if(arr[j] < number[j]){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
              System.out.print(i);
              answer++;
           }
        }
        
        
        return answer;
    }
    
}
