import java.util.*;
class Solution {
    public long solution(double w, double h) {
        long answer = 0;
        long x = 0;
        for(int i=1;i<h;i++){
            x = (long)(w - i*w/h);
            answer += x;
        }
        return answer*2;
    }
}