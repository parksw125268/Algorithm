import java.util.*;
class Solution {
    public String solution(String s) {
        ArrayList<String> aList = new ArrayList<>();
        for (int i =0;i<s.length();i++){
            aList.add(s.substring(i,i+1));
        }
        Collections.sort(aList);
        Collections.reverse(aList);
        String answer = "";
        for (int i =0;i<s.length();i++){
            answer = answer+aList.get(i);    
        }
        return answer;
    }
}