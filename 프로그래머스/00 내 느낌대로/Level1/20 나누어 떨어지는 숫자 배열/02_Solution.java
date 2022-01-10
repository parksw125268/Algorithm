import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> aList = new ArrayList<Integer>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i] % divisor == 0){
                aList.add(arr[i]);
            }
        }
        if (aList.size() == 0){
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[aList.size()];
        for(int i=0;i<aList.size();i++){
            answer[i] = aList.get(i);
        }
        return answer;
    }
}