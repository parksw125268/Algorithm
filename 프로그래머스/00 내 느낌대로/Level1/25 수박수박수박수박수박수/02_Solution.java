class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i=0;i<n/2;i++){
            answer += "수박";
        }        
        for(int i=0;i<n%2;i++){
            answer += "수";
        }
        return answer;
    }
}