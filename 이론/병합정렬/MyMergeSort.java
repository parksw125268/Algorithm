import java.util.ArrayList;
import java.util.Random;

public class MyMergeSort {
    public ArrayList<Integer> merge(ArrayList<Integer> dataList) {
        if (dataList.size() < 2) {
            return dataList;
        }
        Integer middleIdx = dataList.size() / 2;

        ArrayList<Integer> leftList = new ArrayList<Integer>(dataList.subList(0, middleIdx));
        ArrayList<Integer> rightList = new ArrayList<Integer>(dataList.subList(middleIdx, dataList.size()));

        leftList = merge(leftList);
        rightList = merge(rightList);
        return mergeList(leftList, rightList);
    }

    private ArrayList<Integer> mergeList(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        Integer lIdx = 0;
        Integer rIdx = 0;
        ArrayList<Integer> returnList = new ArrayList<Integer>();

        while (leftList.size() > lIdx && rightList.size() > rIdx) {
            if (leftList.get(lIdx) < rightList.get(rIdx)) {
                returnList.add(leftList.get(lIdx));
                lIdx++;
            } else {
                returnList.add(rightList.get(rIdx));
                rIdx++;
            }
        }
        while (leftList.size() > lIdx) {
            returnList.add(leftList.get(lIdx));
            lIdx++;
        }

        while (rightList.size() > rIdx) {
            returnList.add(rightList.get(rIdx));
            rIdx++;
        }
        return returnList;
    }


    public static void main(String[] args){
        ArrayList<Integer> dataList = new ArrayList<>();
        for(int i= 0;i<10;i++){
            dataList.add(new Random().nextInt(100));
        }
        System.out.println(dataList);
        System.out.println(new MyMergeSort().merge(dataList));
    }

}
