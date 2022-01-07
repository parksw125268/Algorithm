import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] counting = new int[N+2];//시작 1, over 1개
        int[] dodal = new int[N+2];
        for(int i=0;i<stages.length;i++){
            counting[stages[i]]++;    
        }
        
        for (int i=1;i<N+2;i++){
            for(int j=1;j<=i;j++){
                dodal[j] += counting[i];
            }
        }
       // i 번째 단계에 도달한 사람 = dodal[i] (1~N 까지만 생각하면 됨)
       // i 번째 스테이지에서 실패한 사람 = counting[i] (실패율 = counting[i]/dodal[i])
        ArrayList<Some> aList = new ArrayList<>();
        for (int i=1;i<=N;i++){
           aList.add(new Some(i , (double)counting[i]/(double)dodal[i]));
        }
        aList = mergeFunc(aList);
        int[] answer = new int[aList.size()];
        for (int i=0;i<aList.size();i++){
            answer[i] = aList.get(i).stage;
        }   
        return answer;
    }
    private ArrayList<Some> mergeFunc(ArrayList<Some> xList){
        if (xList.size() <= 1){
            return xList;
        }
        //1.반으로 잘라. 
        int leng = xList.size();
        ArrayList<Some> left =  new ArrayList<>();
        left. addAll(xList.subList(0, leng/2));
        ArrayList<Some> right = new ArrayList<>();
        right.addAll(xList.subList(leng/2,leng));
        xList.subList(0, leng/2);
        
        //2.각각 정렬
        left = mergeFunc(left);
        right = mergeFunc(right);
        //3.대가리끼리 비교해서 합쳐
        ArrayList<Some> newList = new ArrayList<>();
        while( left.size() != 0 && right.size() != 0 ){
            if(left.get(0).yull > right.get(0).yull ){
                newList.add(left.remove(0));
            }else if(left.get(0).yull < right.get(0).yull ){
                newList.add(right.remove(0));
            }else{
                //yull이 같은 경우니깐 stage가 더 작은것을 먼저 넣고 큰것을 그 뒤에 넣어준다.  
                if(left.get(0).stage < right.get(0).stage ){
                    newList.add(left.remove(0));
                }else{
                    newList.add(right.remove(0));
                }
            }
        }
        if(left.size() == 0){
            newList.addAll(right);
        }else{
            newList.addAll(left);
        }
        //4.리턴
        return newList;
    }
    
    class Some {
        private int stage;
        private double yull;
        public Some(int stage , double yull){
            this.stage = stage;
            this.yull = yull;
        }
    }
    
    
}