import java.util.*;
class Solution {
    public int solution(int n) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        int answer = 0;
        while(n >= 3){
            aList.add(n%3);
            n /= 3;
        }
        aList.add(n);
        for(int i=0;i<aList.size();i++){
            answer += aList.get(aList.size()-1-i) * Math.pow(3,i);
        }
        
        return answer;
    }
}