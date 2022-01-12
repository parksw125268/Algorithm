class Solution {
        long[] powArr;
    public long solution(long n) {
        this.powArr = new long[7071069];
        for(int i=1;i<=7071068;i++){
            powArr[i] = (long)i*i;
        }
        long answer = binarySearch(n);
        if(answer == -1){
            return -1;
        }
        
        return (answer+1) * (answer+1);
    }
    private long binarySearch(long n){
        int left = 1;
        int right = 7071068;
        while(left<=right){
            int mid = (left+right)/2;
            if(powArr[mid] == n){
                return mid;
            }else if(powArr[mid] < n){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}