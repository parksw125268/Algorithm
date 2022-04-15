class Solution {
    public int solution(int n) {
        int[] pArr = new int[n+1];
        pArr[0] = 0;
        pArr[1] = 1;
        for(int i=2;i<=n;i++){
            pArr[i] = (pArr[i-1] + pArr[i-2])%1234567;
        }
        return pArr[n];
    }
}