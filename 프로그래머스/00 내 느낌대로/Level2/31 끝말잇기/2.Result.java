import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int num=0;
        ArrayList<String> sList = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            if (sList.contains(words[i])){ //중복체크
                num = i;
                break;
            }
            if (i!=0){
                if(!isRight(words[i-1],words[i])){
                    num = i;
                    break;
                }
            }
            sList.add(words[i]);
        }
        if(num == 0){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = num%n + 1   ;
            answer[1] = num/n + 1;
        }

        return answer;
    }

    boolean isRight(String s1, String s2){
        if(s1.charAt(s1.length()-1) == s2.charAt(0)){
            return true;
        }
        return false;
    }
}