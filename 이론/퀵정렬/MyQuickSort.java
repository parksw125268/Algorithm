import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MyQuickSort {
    public ArrayList<Integer> qSort(ArrayList<Integer> dataList){
        if (dataList.size() < 2)
            return dataList;
        Integer pivot = dataList.get(0);
        ArrayList<Integer> lList = new ArrayList<>();
        ArrayList<Integer> rList = new ArrayList<>();
        for(int i=1;i<dataList.size();i++){
            if(dataList.get(i)<pivot){
                lList.add(dataList.get(i));
            }else{
                rList.add(dataList.get(i));
            }
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.addAll(this.qSort(lList));
        resultList.add(pivot);
        resultList.addAll(this.qSort(rList));
        return resultList;
    }

    public static void main(String[] args){

            ArrayList<Integer> dataList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                dataList.add(new Random().nextInt(100));
            }
            System.out.println(dataList);
            System.out.println(new MyQuickSort().qSort(dataList));


    }

}
