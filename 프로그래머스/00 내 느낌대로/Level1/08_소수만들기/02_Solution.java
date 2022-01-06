class Solution {
    int cnt; 
    int size;
    int[] used;
    public int solution(int[] nums) {
        used = new int[nums.length];
        this.cnt = 0;
        this.size = nums.length;
        work(0,0,0,nums);
        return cnt;
    }
    
    private void work(int idx, int sum, int startIdx, int[] nums){
        if (idx == 3){
            int sosuCnt=0;
            for (int i=2 ;i<= Math.sqrt(sum);i++ ){
                if(sum%i == 0){
                    sosuCnt++;
                    break;
                }
            }
            if(sosuCnt == 0){ cnt++; } return;
        }else{
            for(int i=startIdx ;i<nums.length;i++){
                if(used[i] == 0){
                    used[i] = 1;
                    sum += nums[i];
                    work(idx+1,sum,i,nums);
                    sum -= nums[i];
                    used[i] = 0;
                }
            }
        }
    }
}