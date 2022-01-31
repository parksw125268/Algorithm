import java.util.*;
class Main{
    public static void main(String[] args){
        ArrayList<Integer> aList = new ArrayList<>();
        for(int i=0;i<100;i++){
            aList.add((int)(Math.random()*100)+1);
        }
        System.out.println(aList);
        aList = sort(aList);
        System.out.println(aList);
    }

    static ArrayList<Integer> sort(ArrayList<Integer> aList){
        if(aList.size() <= 1){
            return aList;
        }
        int pivot = aList.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right= new ArrayList<>();
        for(int i=1;i<aList.size();i++){
            if(aList.get(i) < pivot){
                left.add(aList.get(i));
            }else{
                right.add(aList.get(i));
            }
        }
        left = sort(left);
        right = sort(right);

        left.add(pivot);
        left.addAll(right);
        return left;
    }
}