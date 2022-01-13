import java.util.*;
class Solution {
    public String solution(int n) {
        ArrayList<Integer> aList = new ArrayList<>();
        
        while(n>=3){
            aList.add(n%3);
            n /= 3;
        }
        if(n!=0){
            aList.add(n);
        }
        Collections.reverse(aList);
        while(aList.contains(0)){
            for(int i=0;i<aList.size();i++){
                if(i==0){
                    if(aList.get(i)==0){
                        aList.remove(i);
                        i--;
                    }
                    continue;
                }
                if(aList.get(i) == 0){
                    aList.set(i,3);
                    aList.set(i-1,aList.get(i-1)-1);
                }
            }    
        }
        String answer = "";
        for(int i=0;i<aList.size();i++){
            if(i == 0 && aList.get(i) == 0) continue;
            if(aList.get(i) == 3){
                answer += "4";    
            }else{
                answer += Integer.toString(aList.get(i));
            }
        }
        return answer;
    }
}