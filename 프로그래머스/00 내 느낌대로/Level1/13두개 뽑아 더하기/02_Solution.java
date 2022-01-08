import java.util.*;
class Solution {
    private int[] used;
    private ArrayList<Integer> aList =  new ArrayList<Integer>() ;
    public int[] solution(int[] numbers) {
        used =  new int[numbers.length];
        work(0,0,numbers);        
        int[] answer = new int[aList.size()];
        for (int i=0;i<aList.size();i++){
            answer[i] = aList.get(i);
        }
        Arrays.sort(answer);
        return answer;
        
    }
    private void work(int selectNo, int sum, int[] numbers){
        if (selectNo == 2){
            //중복 체크 
            for(int i=0;i<aList.size();i++){
                if(sum == aList.get(i)){ return; }                                
            } 
            aList.add(sum);
            return;
        }
        for(int i = selectNo;i<numbers.length;i++){
            if(used[i]==0){
                used[i] = 1;
                work(selectNo + 1 , sum + numbers[i], numbers );
                used[i] = 0;
            }
            
        }
    }
}