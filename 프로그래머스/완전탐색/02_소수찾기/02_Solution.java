import java.util.*;
class Solution {
    private ArrayList<Integer> sosuList = new ArrayList<Integer>();
    private String targetString;
    private int[] used; //카드 사용여부를 저장.
    private int size;
    public long solution(String numbers) {
        targetString = numbers;
        size = numbers.length();
        used = new int[size];
        for(int i=1;i<=size;i++){
            findWork(0,i,"");
        }
        return sosuList.size();
    }
    private void findWork(int idx, int untilNum, String sosuNum){
        if (idx == untilNum){
            //sosuNum 을 숫자로 변환
            int sosu = Integer.parseInt(sosuNum);
            if (sosu > 1){
                //sosuNum 이 소수인지 체크
                int cnt = 0;
                for (int i=2;i<=Math.sqrt(sosu);i++){
                    if(sosu%i == 0){
                        cnt++;
                    }
                }
                if (cnt==0){
                    //sosuNum이 sosuList에 있는지 확인 -> 없으면 sosuList에 추가
                    for(int i=0;i<sosuList.size();i++){
                        if (sosu == sosuList.get(i)){
                            return;
                        }
                    }
                    sosuList.add(sosu);
                }
            }
            return;
        }else{
            for (int i=0;i<size;i++){
                if (used[i] != 1) {
                    used[i] = 1;
                    String c = targetString.substring(i, i + 1);
                    findWork(idx+1,untilNum, sosuNum+c);
                    used[i] = 0;
                }
            }
        }
    }
}