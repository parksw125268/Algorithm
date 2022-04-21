class Solution {
    public int[] solution(int n, long left, long right) {
        int cnt = (int)(right - left +1);
        int ansIdx = 0;
        int currIdx = (int)(left % n);
        int[] ans = new int[cnt];
        int fromIdx = (int)(left/n+1);
        int toIdx   = (int)(right/n+1);
        for(int i=fromIdx;i<=toIdx;i++){
            while(currIdx<n){
                if(i<=currIdx)
                    ans[ansIdx] = currIdx+1;
                else
                    ans[ansIdx] = i;
                ansIdx++;
                currIdx++;
                if(ansIdx == cnt)
                    return ans;
            }
            currIdx = 0;
        }
        return ans;
    }
}