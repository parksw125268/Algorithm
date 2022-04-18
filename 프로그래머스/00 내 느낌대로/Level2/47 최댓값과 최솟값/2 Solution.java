import java.util.*;
class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int leng = sArr.length;
        int[] iArr = new int[leng];
        for(int i=0;i<leng;i++){
            iArr[i] = Integer.parseInt(sArr[i]);
        }
        Arrays.sort(iArr);
        return Integer.toString(iArr[0])+" "+Integer.toString(iArr[leng-1]);
    }
}