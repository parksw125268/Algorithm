import java.util.ArrayList;

public class MyHeap {
    private ArrayList<Integer> heapList = new ArrayList<>();


    private boolean isFoundPosition(int childIdx) {
        if(childIdx <= 1) {
            return true;
        }
        if (heapList.get(childIdx) <= heapList.get(childIdx/2)){
            return true;
        }else{
            return false;
        }
    }

    private void setPosition(){
        int childIdx = 0;
        int parentIdx = 0;
        childIdx = heapList.size()-1;
        parentIdx = childIdx/2;

        while(!isFoundPosition(childIdx)){
            int a = 0;
            a = heapList.get(childIdx);
            heapList.set(childIdx, heapList.get(parentIdx));
            heapList.set(parentIdx, a);
            childIdx = childIdx/2;
        }
    }


    public void insertData(Integer data){
        if(heapList.isEmpty()){
            heapList.add(null);
            heapList.add(data);
            return;
        }
        heapList.add(data);
        //제자리 찾기
        setPosition();
    }
    public int pop(){
        if(heapList.isEmpty()){
            return -1;
        }
        return heapList.get(1);
    }
    public void printFunc(){
        System.out.println(heapList);
    }

    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        myHeap.insertData(20);
        myHeap.insertData(21);
        myHeap.insertData(13);
        myHeap.insertData(2);
        myHeap.insertData(47);
        myHeap.insertData(22);
        myHeap.insertData(23);
        myHeap.printFunc();
        System.out.println();
        System.out.println(myHeap.pop());

    }
}
