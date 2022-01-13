import java.util.*;
class Solution {
    private String s;
    private int size;
    public int solution(String s) {
        this.s = s;
        this.size = s.length();
        int min = size;//1개씩 자르면 최소값은 size
        for(int i = 1;i<= size/2;i++){
            min = Math.min(min,work(i)); //work() 는 i개씩 잘랐을때 길이를 리턴
        }

        return min;
    }
    private int work(int cSize){
        ArrayList<String> aList = new ArrayList<>();
        String newS = "";
        //cSize개씩 자르기
        for(int i=0;i<size;i+=cSize){
            if(size-i > cSize){//앞부터 갯수만
                aList.add(s.substring(i,i+cSize));
            }else{//맨마지막은 남은 자투리 다 잘라넣기큼 자르다가
                aList.add(s.substring(i,size));
            }
        }
        String beforeS = aList.get(0);
        int cnt = 1;
        for(int i=1;i<aList.size();i++){
            if(beforeS.equals(aList.get(i))){
                cnt++;
                aList.remove(i);
                i-=1;
            }else{
                if(cnt > 1){
                    newS += Integer.toString(cnt);
                }
                newS += beforeS;
                cnt = 1;
                beforeS = aList.get(i);
            }
        }
        if(cnt > 1){
            newS += Integer.toString(cnt);
        }
        newS += beforeS;
        return newS.length();
    }
}