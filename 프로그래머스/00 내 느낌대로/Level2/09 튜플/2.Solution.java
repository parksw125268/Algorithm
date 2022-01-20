import java.util.*;
class Solution {
    ArrayList<String> sList = new ArrayList<>();
    public int[] solution(String s) {
        s = s.substring(2,s.length()-2);
        parsing(s);//나누기 
        sList = mSort(sList); //길이 짧은 순으로 정렬 
        return getTuple(sList);
    }
    private int[] getTuple(ArrayList<String> sList){
        ArrayList<Integer> aList = new ArrayList<>();
        for(int i=0;i<sList.size();i++){
            String[] srr = sList.get(i).split(",");
            for(int j=0;j<i+1;j++){
                if(!aList.contains(Integer.parseInt(srr[j]))){
                    aList.add(Integer.parseInt(srr[j]));
                    break;
                }
            }
        }
        int[] arr = new int[aList.size()];
        for (int i=0;i<aList.size();i++){
            arr[i] = aList.get(i);
        }
        return arr;
    }
    
    private ArrayList<String> mSort(ArrayList<String> aList){
        if(aList.size()<=1){
            return aList;
        }
        //1.둘로 나눈다. 
        ArrayList<String> left = new ArrayList<>();
        left.addAll(aList.subList(0,aList.size()/2));
        ArrayList<String> right = new ArrayList<>();
        right.addAll(aList.subList(aList.size()/2,aList.size()));
        //2. 각각 정렬
        left = mSort(left);
        right = mSort(right);
        //3. 각각 대가리끼리 비교하며 합치며 정렬
        ArrayList<String> newList = new ArrayList<>();
        while(left.size()!=0 && right.size()!= 0){
            if(left.get(0).length() < right.get(0).length() ){
                newList.add(left.remove(0));   
            }else{
                newList.add(right.remove(0));   
            }
        }
        //자투리 다 더하기 
        if(left.size()==0){
            newList.addAll(right);      
        }else{
            newList.addAll(left); 
        }
        return newList;
    }
    
    private void parsing(String s){
        int fromIdx = 0;
        for(int i=0;i<s.length()-2;i++){
            if(s.substring(i,i+3).equals("},{")){
                sList.add(s.substring(fromIdx,i));
                i += 3;
                fromIdx = i;
            }
        }
        sList.add(s.substring(fromIdx,s.length()));
    }
}