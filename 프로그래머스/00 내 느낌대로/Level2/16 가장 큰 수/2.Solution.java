import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> aList = new ArrayList<>();
        
        for(int i=0;i<numbers.length;i++){  
            aList.add(Integer.toString(numbers[i]));
        }
        aList = qSort(aList);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<aList.size();i++){
            sb.append(aList.get(i));
        }
        
        String answer = sb.toString();
        return answer.charAt(0) == '0' ? "0" : answer;
    }

    ArrayList<String> qSort(ArrayList<String> aList){
        if(aList.size()<=1){
            return aList;
        }
        String pivot = aList.get(0);
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        for(int i=1;i<aList.size();i++){
            int p_a = Integer.parseInt(pivot+aList.get(i));
            int a_p = Integer.parseInt(aList.get(i)+pivot);
            if(p_a > a_p){
                right.add(aList.get(i));
            }else{
                left.add(aList.get(i));
            }
        }
        left = qSort(left);
        right = qSort(right);
        left.add(pivot);
        left.addAll(right);
        return left;
    }
}