import java.util.*;
class Solution {
    int n;
    ArrayList<int[]> aList = new ArrayList<>();
    public int[] solution(int n) {
        this.n = n;
        init();
        work();
      //  toString1();
        return getAnswer();
    }
    int[] getAnswer(){
        int[] answer = new int[(1+n)*n/2];
        int idx = 0;
        for(int[] arr : aList){
            for(int j : arr){
                answer[idx] = j;
                idx++;
            }
        }
        return answer;
    }
    void work(){
        int start1 = 0;
        int start2 = 1;
        int deep = 0;
        int gub = 0;
        int cnt = 0;
        for(int i=n;i>0;i--){
            gub++;
            if(gub%3 == 1){         //아래로
                for(int j=0;j<i;j++){
                    cnt++;
                    aList.get(start1+j)[deep] = cnt;
                }
                start1+=2;
            } else if(gub%3 == 2){  //가로로
                for(int j=0;j<i;j++){
                    cnt++;
                    aList.get(n-1-deep)[start2+j] = cnt;
                }
            } else{                 //위로 
                for(int j=0;j<i;j++){
                    cnt++;
                    int leng = aList.get(n-1-start2-j).length;
                    aList.get(n-1-start2-j)[leng-1-deep] = cnt;
                }
                deep++; 
                start2++;
            }
        }
    }
    void init(){
        for(int i=1;i<=n;i++){
            aList.add(new int[i]);
        }
    }
    void toString1(){
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(aList.get(i)));
        }
    }
}