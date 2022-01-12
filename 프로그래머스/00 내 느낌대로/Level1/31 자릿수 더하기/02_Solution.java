import java.util.*;

public class Solution {
    public int solution(int n) {
        String s = Integer.toString(n);
        int answer = 0;
        for(int i=0;i<s.length();i++){
            answer += Integer.parseInt(s.substring(i,i+1));
        }

        return answer;
    }
}