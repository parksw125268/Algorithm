class Solution {
    public long solution(int a, int b) {
        int cnt;
        if(a<b){
            cnt = b-a+1;
        }else{
            cnt = a-b+1;
        }
        long answer = (long) (a+b) * cnt / 2;
        return answer;
    }
}