class Solution {
    boolean solution(String s) {
        s = s.toUpperCase();
        int pCnt = 0;
        int yCnt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'P'){
                pCnt++;
            }else if(s.charAt(i) == 'Y'){
                yCnt++;    
            }
        }


        return pCnt == yCnt;
    }
}