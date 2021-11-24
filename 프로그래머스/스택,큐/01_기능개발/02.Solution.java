import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int leng = speeds.length;
        ArrayList<Integer> answerList = new ArrayList<>();
        while(!isComplete(progresses)){
            for (int i =0 ; i<leng;i++){
                if (progresses[i] != -1) {
                    progresses[i] += speeds[i];
                }
            }
            boolean a = false;
            int cnt = 0;
            for (int i=0;i<leng;i++){
                if(!a){
                    if(progresses[i]<100){
                        continue;
                    }
                    if(i == 0){
                        a=true;
                    }else if (progresses[i-1] == -1) {
                        a = true;
                    }else{
                        continue;
                    }
                }
                if(progresses[i] >= 100){
                    cnt++;
                    progresses[i] = -1;
                }else{
                    break;
                }
            }
            if (cnt > 0){
                answerList.add(cnt);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0 ; i< answer.length ; i++){
            answer[i] = answerList.get(i);
        }
        return  answer;
    }

    private boolean isComplete(int[] aArray){
        for (int i=0 ; i< aArray.length;i++){
            if (aArray[i] > -1 && aArray[i] < 100 ){
                return false;
            }
        }
        return true;
    }

   /* public static void main(String[] args) {
        Solution s = new Solution();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] a = s.solution(progresses,speeds);
        for( int i= 0 ; i < a.length ; i++){
            System.out.println(a[i]);
        }
    }*/
}