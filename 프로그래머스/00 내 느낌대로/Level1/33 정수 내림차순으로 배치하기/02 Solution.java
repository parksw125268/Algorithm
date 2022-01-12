import java.util.*;
class Solution {
    public long solution(long n) {
        String s = Long.toString(n);
        ArrayList<String> aList = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            aList.add(s.substring(i,i+1));
        }
        aList = mergeSort(aList);
        s = "";
        for(int i=0;i<aList.size();i++){
            s += aList.get(i);
        }
        long answer = Long.parseLong(s);
        return answer;
    }
    private ArrayList<String> mergeSort(ArrayList<String> aList){
        if(aList.size() <= 1){
            return aList;
        }
        //1 반으로 나눈다.
        //2 각각 정렬
        //3 앞에것끼리 비교하며 merge
        //4 합친것 return 
        
        //1
        ArrayList<String> left = new ArrayList<>(aList.subList(0,aList.size()/2));           
        ArrayList<String> right = new ArrayList<>(aList.subList(aList.size()/2,aList.size()));
        
        //2
        left = mergeSort(left);                                                         
        right = mergeSort(right);
        
        ArrayList<String> newList = new ArrayList<>(); 
        //3
        while( left.size() != 0 && right.size() != 0){
            if(Integer.parseInt(left.get(0)) > Integer.parseInt(right.get(0))){
                newList.add(left.remove(0));
            }else{
                newList.add(right.remove(0));
            }
        }
        if(left.size() != 0){
            newList.addAll(left);
        }else{
            newList.addAll(right);
        }
        //4
        return newList;
    }
    
}