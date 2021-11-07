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
        int childIdx;
        int parentIdx;
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
    private boolean hasChild(int idx){
        if (idx*2 > heapList.size()-1) { //왼쪽 트리가 없으면 자식이 없는것.
            return false;
        }else {
            return true;
        }
    }
    public int pop(){
        if(heapList.isEmpty()){
            return -1;
        }else if(heapList.size() == 2){
            heapList.remove(0);
            return heapList.remove(0);
        }
        int result;
        result = heapList.get(1);
        heapList.set(1,heapList.remove(heapList.size()-1));

        int parentIdx = 1;
        while(hasChild(parentIdx)){
            if (parentIdx*2+1 == heapList.size()-1){
                //왼쪽 오른쪽 둘다 있는경우
                if (heapList.get(parentIdx*2) > heapList.get(parentIdx)){
                    //왼쪽 자식이 더 큰 경우
                    int a;
                    a = heapList.get(parentIdx);
                    heapList.set(parentIdx, heapList.get(parentIdx*2));
                    heapList.set(parentIdx*2,a);
                    parentIdx = parentIdx*2;
                }else if(heapList.get(parentIdx*2+1) > heapList.get(parentIdx)){
                    //오른쪽 자식이 더 큰경우
                    int a;
                    a = heapList.get(parentIdx);
                    heapList.set(parentIdx, heapList.get(parentIdx*2+1));
                    heapList.set(parentIdx*2+1,a);
                    parentIdx = parentIdx*2+1;
                }else{
                    //바꿀 필요가 없음.
                    break;
                }
            }else{
                //왼쪽만 있는경우
                if (heapList.get(parentIdx*2) > heapList.get(parentIdx)){
                    //왼쪽 자식이 더 큰 경우
                    int a;
                    a = heapList.get(parentIdx);
                    heapList.set(parentIdx, heapList.get(parentIdx*2));
                    heapList.set(parentIdx*2,a);
                    parentIdx = parentIdx*2;
                }else{
                    //바꿀 필요 없음.
                    break;
                }
            }
        }
        return result;
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
        System.out.println(myHeap.pop());
        myHeap.printFunc();
        System.out.println(myHeap.pop());
        myHeap.printFunc();
        System.out.println(myHeap.pop());
        myHeap.printFunc();
    }
}
