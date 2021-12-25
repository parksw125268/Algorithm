import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyInsertSort ms  = new MyInsertSort();
        ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(1,5,74,8,5,32,51,1,3,64,9,8,4,8,5,4,8,4,8,84,48,80,13,1,55,1,31,8,48,1));
        System.out.println(ms.sortFunc(aList));                 //1 5 5 32 8 74
    }
}
class MyInsertSort{
    public ArrayList<Integer> sortFunc(ArrayList<Integer> dataList){
        for(int i=1;i<dataList.size();i++){
            for(int j=i;j>0;j--){
                if(dataList.get(j-1) > dataList.get(j)){
                    swap(dataList,j-1,j);
                }else{
                    break;
                }
            }
        }
        return dataList;
    }
    private void swap (ArrayList<Integer> aList,int idx1,int idx2){
        int a = aList.get(idx1);
        aList.set(idx1,aList.get(idx2));
        aList.set(idx2, a);
    }

}
