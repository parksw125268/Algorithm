class Solution {
    public String solution(String s) {
        String answer = "";
        int strIdx = -1;
        for(int i=0;i<s.length();i++){
            if(s.substring(i,i+1).equals(" ")){
                strIdx = -1;
                answer  += " ";
            }else{
                strIdx++;
                if(strIdx%2 == 0){
                    answer += s.substring(i,i+1).toUpperCase();
                }else{
                    answer += s.substring(i,i+1).toLowerCase();
                }
            }
        }
        return answer;
    }
}