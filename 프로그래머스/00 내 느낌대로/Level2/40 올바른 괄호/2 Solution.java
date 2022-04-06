import java.util.*;
class Solution {
    boolean solution(String s) {
        int leng=s.length();
        ArrayList<Integer> aList = new ArrayList<>();
        for(int i=0;i<leng;i++){
            if(s.charAt(i) == '('){
                aList.add(1);
            }else{
                if (aList.size() == 0){
                    return false;
                }else{
                    aList.remove(aList.size()-1);
                }
            }
        }
        if(aList.size()==0) return true;
        else return false;
    }
}