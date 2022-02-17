import java.util.*;
class Main{
    public static void main(String[] args) {
        ArrayList<Integer> aList = new ArrayList<>();
        for(int i =0;i<100;i++){
            aList.add((int)(Math.random()*100));
        }
        System.out.println(aList);
        aList = qSort(aList);
        System.out.println(aList);

    }

    private static ArrayList<Integer> qSort(ArrayList<Integer> aList){
        if(aList.size()<=1){
            return aList;
        }
        Integer p = aList.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for(int i =1 ;i<aList.size();i++){
            if(aList.get(i) < p){
                left.add(aList.get(i));
            }else{
                right.add(aList.get(i));
            }
        }
        left = qSort(left);
        right = qSort(right);
        left.add(p);
        left.addAll(right);
        return left;
    }
}