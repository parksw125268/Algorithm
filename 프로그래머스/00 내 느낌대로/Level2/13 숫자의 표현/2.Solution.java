class Solution {
    public int solution(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        int left = 1;
        int right = 1;
        int cnt = 0;        
        while(left<=right && right <= n){
            int sum = 0;
            for(int i=left ; i<=right; i++){
               sum+=i; 
            }
            if(n == sum){
                cnt++;
                right++;
            }else if(sum > n){
                left++;
            }else{
                right++;
            }
        }
        return cnt;
    }
}