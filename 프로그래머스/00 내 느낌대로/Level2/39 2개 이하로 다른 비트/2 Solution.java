import java.util.*;
class Solution {
    long[] numbers;
    long[] answer;
    public long[] solution(long[] numbers) {
        this.numbers = numbers;
        this.answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            work(i);
        }
        return answer;
    }
    void work(int idx){
        long stand = numbers[idx];
        String standStr = Long.toBinaryString(stand);
        int sLeng = standStr.length();
        if (standStr.charAt(sLeng-1) == '0'){
            answer[idx] = stand+1;
            return;
        }
        if(standStr.charAt(0) == '1'){
            standStr = "0"+standStr;
            sLeng += 1;
        }
        char[] cArr = new char[sLeng];
        int findIdx = 0;
        for(int i=sLeng-1;i>=0;i--){
            cArr[sLeng-i-1] = standStr.charAt(i);  
            if(findIdx == 0 && cArr[sLeng-i-1] == '0'){
                findIdx = sLeng-i-1;
            }
        }
        cArr[findIdx] = '1';
        cArr[findIdx-1] = '0';
        for(int i=0;i<sLeng;i++){
            if(cArr[i] == '1')
                answer[idx] += (long)Math.pow(2,i);
        }
    }
}