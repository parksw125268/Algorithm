import java.util.*;
class Solution {
    int[] arr;
    ArrayList<Integer> aList = new ArrayList<>();     
    public int solution(int[] arr) {
        this.arr = arr;
        for(int i :arr) aList.add(i);
        return getAnswer();
    }
    int getAnswer(){
        while(aList.size() > 1){
            int a = aList.remove(0);
            int b = aList.remove(0);
            if(a>b) aList.add(getLCM(a,b));
            else aList.add(getLCM(b,a));
            System.out.println(aList);
        }
        return aList.get(0);
    }
    int getLCM(int a, int b){
        int temp = a;
        int cnt = 1;
        while(temp%b !=0){
            cnt++;
            temp = a*cnt;
        }
        return temp;
    }
}