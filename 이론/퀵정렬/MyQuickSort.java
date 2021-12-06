import java.util.ArrayList;
public class MyQuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> aList){
        if (aList.size() <= 1){
            return aList;
        }
        //1.pivot을 정하고 왼쪽 오른쪽 분류한다.
        //2.왼쪽 오른쪽 분류한것을 정렬한다(재귀)
        //3.합치고 return하낟.
        //======== start ============
        int pivot = aList.get(0); //-------------------------------------- 1.
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for(int i=1;i<aList.size();i++){
            if(aList.get(i)<pivot){
                left.add(aList.get(i));
            }else{
                right.add(aList.get(i));
            }
        }
        //-------------------------------------- 2,3
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.addAll(this.sort(left));//재귀
        resultList.add(pivot);
        resultList.addAll(this.sort(right));
        return resultList;
    }

    public static void main(String[] args){
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i=0; i<100;i++){
            testData.add((int)(Math.random()*100));
        }
        MyQuickSort mq = new MyQuickSort();
        System.out.println(testData);
        System.out.println();
        System.out.println(mq.sort(testData));
    }
}
