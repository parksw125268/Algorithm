class Solution {
    public String solution(String s) {
        s = " "+s;
        String answer = "";
        for(int i=1;i<s.length();i++){
            answer += (s.charAt(i-1) == ' ' && s.charAt(i) != ' ') ? 
                s.substring(i,i+1).toUpperCase() :
                s.substring(i,i+1).toLowerCase() ;
        }
        return answer;
    }
}