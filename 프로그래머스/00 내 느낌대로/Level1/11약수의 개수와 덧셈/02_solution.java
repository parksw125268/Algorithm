//약수의 개수는 보통 짝수이다. 홀수인 경우는 제곱근이 정수인 경우
import java.util.*;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i= left ;i<=right;i++){
            if(i%Math.sqrt(i)==0){
                answer -= i;
            }else{
                answer += i;
            }
        }
        return answer;
    }
}