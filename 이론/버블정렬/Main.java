import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BubbleSort sort = new BubbleSort();
        ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(100,4,45,3,1,4,8,3,5,4,46,45,98,31,1,58,8,3,4,8,54,86,15,15,16,84,45,35,48,4,52,385,8,5,354,8,5,38,4,3,4));
        System.out.println(sort.sortFunc(aList));
    }
}
class BubbleSort{
    public ArrayList<Integer> sortFunc(ArrayList<Integer> dataList){
        for(int i=0;i< dataList.size()-1 ; i++){
            int changeCnt = 0;
            for(int j=0;j<dataList.size()-1-i;j++){
                if(dataList.get(j)>dataList.get(j+1)){
                    swap(dataList,j,j+1);
                    changeCnt++;
                }
            }
            if (changeCnt == 0){
                break;
            }
        }
        return dataList;
    }
    private void swap(ArrayList<Integer> swapList,int idx1, int idx2){
        int a = swapList.get(idx1);
        swapList.set(idx1, swapList.get(idx2));
        swapList.set(idx2, a);
    }
}

