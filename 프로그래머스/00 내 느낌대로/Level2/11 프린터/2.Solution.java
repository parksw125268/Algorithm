import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        ArrayList<Integer> aList = new ArrayList<>();
        for(int i=0;i<priorities.length;i++){
            aList.add(priorities[i]);
        }
        int value = aList.get(location);
        int currValue;
        int cnt = 0;
        while(aList.size()!=0){
            currValue = aList.remove(0);
            location--;
            boolean isThere = false;//우선순위가 자기보다 높은게 있는가?
            for(int i=currValue+1;i<=9;i++){
                if(aList.contains(i)){
                    isThere = true;
                    if(location == -1){
                        location = aList.size();
                    }
                    aList.add(currValue);
                    break;
                }
            }
            if(!isThere){
                cnt++;
            }
            if(location == -1){//location에 있던것이 출력되었음.
                break;
            }
        }
        return cnt;
    }
}