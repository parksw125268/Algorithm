class Solution {
    int cnt = 0;
    public int solution(int n) {

        String s = Integer.toBinaryString(n);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1') cnt++;
        }
        int answer = n+1;

        while(!isSameOne(answer)){
            answer++;
        }

        return answer;
    }
    boolean isSameOne(int num){
        int cnt2=0;
        String s = Integer.toBinaryString(num);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1') cnt2++;
        }
        if(cnt == cnt2) return true;
        else return false;
    }
}