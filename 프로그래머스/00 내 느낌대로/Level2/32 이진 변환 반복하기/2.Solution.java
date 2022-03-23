class Solution {
    String s;
    int removeCnt = 0;
    int changeCnt = 0;
    public int[] solution(String s) {
        this.s = s;
        work();
        
        int[] answer = {changeCnt,removeCnt};
        return answer;
    }
    void work(){
        while(s.length() > 1){
            removeCnt += removeZero();    
            changeToBinary();
            changeCnt++;
        }
    }
    
    void changeToBinary(){
        int num = s.length();
        String newS = "";
        while(num >= 2){
            newS = Integer.toString(num%2) + newS;
            num /= 2;   
        }
        newS = Integer.toString(num) + newS;
        s = newS;
    }
    
    int removeZero(){
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0'){
                cnt++;
            }
        }
        s = s.replace("0","");
        return cnt;
    }
}