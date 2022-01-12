import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            arr[0] = -1;
            return arr;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            min = Math.min(min,arr[i]);
        }
        int idx = 0;
        int[] answer = new int[arr.length-1];
        for(int i=0;i<arr.length;i++){
            if(arr[i] != min){
                answer[idx] = arr[i];
                idx++;
            }
        }
        return answer;
    }
}