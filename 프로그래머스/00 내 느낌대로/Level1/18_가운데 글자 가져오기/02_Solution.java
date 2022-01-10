class Solution {
    public String solution(String s) {
        int from, to = 0;
        String answer = "";
        if(s.length()%2 == 0){            
            from = s.length()/2-1;
        }else{            
            from = s.length()/2;
        }
        to = s.length()/2+1;
        answer = s.substring(from,to);
        return answer;
    }
}