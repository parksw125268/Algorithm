import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int leng = citations.length;
        
        int[] nonCnt = new int[leng];
        Arrays.sort(citations);
        for(int i=0;i<leng;i++){
            nonCnt[i] = leng - i;
        }
        int left = 0;
        int right =leng-1;
        int mid = (left+right)/2;
        int ans = -1;
        while(left<=right){
            mid = (left+right)/2;
            if( nonCnt[mid] >= citations[mid]){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(ans == -1){
            return nonCnt[0];
        }
        if(citations[ans] == nonCnt[ans]){
            return nonCnt[ans];
        }
        return nonCnt[ans]-1;
    }
}