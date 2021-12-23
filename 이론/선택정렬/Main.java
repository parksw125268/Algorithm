import java.util.*;

public class Main {
    public static void main(String[] args) {
        MySelectSort ms  = new MySelectSort();
        ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(1,5,74,8,5,32,51,1,3,64,9,8,4,8,5,4,8,4,8,84,48,80,13,1,55,1,31,8,48,1));
        System.out.println(ms.sortFunc(aList));
    }
}
class MySelectSort{
    public ArrayList<Integer> sortFunc(ArrayList<Integer> dataList){
        int listSize = dataList.size();
        for(int outIdx=1; outIdx<listSize;outIdx++){
            int swapIdx = -1;
            int min = dataList.get(outIdx-1);
            for(int inIdx=outIdx;inIdx<listSize;inIdx++){
                if( min > dataList.get(inIdx)){
                    swapIdx = inIdx;
                    min = dataList.get(inIdx);
                }
            }
            if (swapIdx != -1) {
                swap(dataList, outIdx-1, swapIdx);
            }
        }
        return dataList;
    }
    private void swap(ArrayList<Integer> list,int idx1,int idx2){
        int a = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, a);
    }
}
