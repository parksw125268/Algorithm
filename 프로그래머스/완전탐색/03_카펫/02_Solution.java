import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer =  new int[2];
        
        for (int i=1;i<=Math.sqrt(yellow);i++){
            if(yellow%i == 0 ){
                if ( ((i+1) + (yellow/i + 1))*2 == brown){
                    answer[0] = yellow/i+2;
                    answer[1] = i+2; 
                } 
            }
        }
        return answer;
    }
}