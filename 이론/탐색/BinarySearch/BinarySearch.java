import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BinarySearch {
    public boolean binarySearch(ArrayList<Integer> dataList , Integer num ) {
        if (dataList.size() == 0)
            return false;
        if (dataList.size() == 1) {
            if (dataList.get(0) == num)
                return true;
            else if (dataList.get(0) != num)
                return false;
        }
        int middleIdx = dataList.size() / 2;

        if (dataList.get(middleIdx) == num)
            return true;
        else {
            if (dataList.get(middleIdx) > num)
                return this.binarySearch(new ArrayList<Integer>(dataList.subList(0, middleIdx)), num);
            else
                return this.binarySearch(new ArrayList<Integer>(dataList.subList(middleIdx, dataList.size())), num);

        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0 ; i<40 ; i++){
            dataList.add(new Random().nextInt(100));
        }
        System.out.println(dataList);
        Collections.sort(dataList);
        System.out.println(dataList);
        System.out.println(new BinarySearch().binarySearch(dataList,30));
    }

}
