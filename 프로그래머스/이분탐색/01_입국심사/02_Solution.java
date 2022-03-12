class Solution {
    private int[] times;
    private int n;
    public long solution(int n, int[] times) {
        this.n = n;
        this.times=times;
        long answer = 0;
        int max = times[0];
        int min = 1;

        for(int i=1;i<times.length;i++){
            max = Math.max(max,times[i]);
        }
        long left = min; 
        long right = (long)max * n;
         
        while(left<=right){

            long mid = (left+right)/2;
            if(isAble(mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        
        return answer;
    }
    private boolean isAble(long time){
        long sum = 0;
        for(int i : times) {
            sum += time / i; // 각 심사위원이 주어진 시간에 심사할 수 있는 사람 수
        }
        if(n <= sum){
            return true;
        }
        return false;
    }
}