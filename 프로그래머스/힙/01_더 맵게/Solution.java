import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int leng = scoville.length;
        int answer = 0 ;
        MyHeap mh = new MyHeap();
        for(int i=0; i<leng; i++){
            mh.inputData(scoville[i]);
        }
        int a = mh.popData(); //제일 안 매운애
        int b = mh.popData(); //두번째로 안 매운애
        while(a >= 0 && b >= 0){
            if(a>=K){
                return answer;
            }
            int c = a + (b*2);//섞기
            mh.inputData(c); //섞은것 다시 넣기
            answer++;
            //다시 뽑기
            a = mh.popData();
            b = mh.popData();

        }
        if (b == -1 && a>=K){ //1개 남은것을 뽑으면 b에 -1이 들어있음.
            return answer;
        }else{
            return -1;
        }
    }

    class MyHeap{
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
            if(this.heapList.size() <= 1){
                return -1;
            }
            int pop = this.heapList.get(1);
            this.heapList.set(1,this.heapList.remove(this.heapList.size()-1));
            int pIdx = 1;
            int cIdx ;
            while(hasChild(pIdx)){
                if(this.heapList.size()-1 < pIdx*2+1){ //1.자식이 왼쪽에만 있는경우
                    cIdx = pIdx*2;
                }else{                              //2.자식이 오른쪽에도 있는경우
                    if(this.heapList.get(pIdx*2)<this.heapList.get(pIdx*2+1)){
                        cIdx= pIdx*2;
                    }else{
                        cIdx= pIdx*2+1;
                    }
                }
                if(this.heapList.get(cIdx) < this.heapList.get(pIdx)){
                    int a = heapList.get(cIdx);
                    this.heapList.set(cIdx, this.heapList.get(pIdx));
                    this.heapList.set(pIdx, a);
                    pIdx = cIdx;
                    continue;
                }
                return pop;
            }
            return pop;
        }
        private boolean hasChild(int pIdx){
            if(this.heapList.size()-1 < pIdx*2){
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{1,2,3,9,10,12};
        System.out.println(s.solution(a ,7));

    }
}