import java.util.*;

public class Solution {
  public int solution(int n) {
    int cnt = 0;
    while(n!=0){
      if(n%2 == 0){
        n = n/2;
      }else{
        n -= 1;
        cnt += 1;
      }
    }
    return cnt;
  }
}