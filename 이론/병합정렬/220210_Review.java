import java.util.*;
class Main{
    public static void main(String[] args){
        ArrayList<Integer> aList = new ArrayList<>();
        for(int i=0;i<100;i++){
            aList.add((int)(Math.random()*100));
        }
        System.out.println(aList);
        aList = mSort(aList);
        System.out.println(aList);
    }
    static ArrayList<Integer> mSort(ArrayList<Integer> aList){
        if (aList.size()<=1){
            return aList;
        }

        ArrayList<Integer> left = new ArrayList<>(aList.subList(0,aList.size()/2));
        ArrayList<Integer> right = new ArrayList<>(aList.subList(aList.size()/2, aList.size()));
        ArrayList<Integer> newList = new ArrayList<>();
        left = mSort(left);
        right = mSort(right);
        while(left.size()!= 0 && right.size()!= 0 ){
            if(left.get(0) < right.get(0)){
                newList.add(left.remove(0));
            }else{
                newList.add(right.remove(0));
            }
        }
        if(left.size()!= 0){
            newList.addAll(left);
        }else{
            newList.addAll(right);
        }
        return newList;
    }
}