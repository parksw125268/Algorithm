import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int leng = scoville.length;
        int answer = 0 ;
        MyHeap mh = new MyHeap();
        for(int i=0; i<leng; i++){
            mh.inputData(scoville[i]);
        }
        // 힙에는 문제가 없음.
        //다음 로직을 잘짜야됨.

        /*for(int i=0; i<leng; i++){
            System.out.println(mh.popData());
        }*/
        return answer;

    }

     static class MyHeap{
        ArrayList<Integer> heapList = new ArrayList<>();

        public void inputData(int data){
            if(this.heapList.size() == 0){
                this.heapList.add(null);
                this.heapList.add(data);
                return;
            }
            this.heapList.add(data);
            int cIdx = this.heapList.size()-1;
            int pIdx = cIdx/2;
            while(this.heapList.get(cIdx)<this.heapList.get(pIdx)){
                int a = heapList.get(cIdx);
                this.heapList.set(cIdx, this.heapList.get(pIdx));
                this.heapList.set(pIdx, a);
                cIdx = pIdx;
                pIdx = cIdx / 2;
                if (pIdx == 0){
                    return;
                }
            }
        }

        public int popData(){
            if(this.heapList.size()<=1){
                return -1;
            }
            int popNum = heapList.get(1);
            if (this.heapList.size() == 2){
                return this.heapList.remove(1);
            }
            heapList.set(1, heapList.remove(heapList.size()-1));

            int pIdx = 1;
            int cIdx ;

            while(hasChild(pIdx)){
                if(this.heapList.size()-1 < pIdx*2+1){//1. 왼쪽만 있는경우,
                    cIdx = pIdx*2;
                    if(this.heapList.get(cIdx) < this.heapList.get(pIdx)){
                        swapPosition(cIdx,pIdx);
                    }
                    return popNum;
                }else{ // 2.둘다 있는경우
                    if(this.heapList.get(pIdx*2) < this.heapList.get(pIdx*2+1)){ //왼쪽이 더 작은 경우
                        cIdx = pIdx * 2 ;
                    }else{  //오른쪽이  더 작은경우
                        cIdx = pIdx * 2 + 1;
                    }
                    if(this.heapList.get(cIdx) < this.heapList.get(pIdx)){
                        swapPosition(cIdx,pIdx);
                    }
                    pIdx = cIdx;
                }
            }
            return popNum;
        }

        private boolean hasChild(int pIdx){
            if(this.heapList.size()-1 < pIdx*2){
                return false;
            }
            return true;
        }

        private void swapPosition(int cIdx, int pIdx){
            int a = this.heapList.get(pIdx);
            this.heapList.set(pIdx, heapList.get(cIdx));
            this.heapList.set(cIdx, a);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{15,9,10,121,2,3,9,10,12,1,2,3};
        s.solution(a ,7);

    }
}