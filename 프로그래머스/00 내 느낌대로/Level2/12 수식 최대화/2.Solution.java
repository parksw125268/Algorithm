import java.util.*;
class Solution {
    String s;
    long max;
    char[] operator = {'*','-','+'};
    int[] used = new int[3];
    char[] selected = new char[3];
    ArrayList<String> aList = new ArrayList<>();
    
    public long solution(String expression) {
        this.max = 0;
        s = expression;
        parsing();
        work(0);
        return max;
    }
    private void work(int idx){
        if(idx == 3){
            max = Math.max(max,calc()); //selected에 따라 계산
            return;
        }
        for(int i=0;i<3;i++){
            if(used[i] == 0){
                used[i] = 1;  
                selected[idx] = operator[i];
                work(idx+1);     
                used[i] = 0;  
            }
        }
    }
    private long calc(){
        ArrayList<String> sList = new ArrayList<>(aList);
        //selected 에 순서대로 계산.
        for(int i=0;i<3;i++){
            for(int j=0;j<sList.size();j++){
                if(sList.get(j).charAt(0) == selected[i]){
                    long oper1 = Long.parseLong(sList.get(j-1));
                    long oper2 = Long.parseLong(sList.get(j+1));
                    long result;
                    if (selected[i] == '*'){
                        result = oper1 * oper2; 
                    }else if(selected[i] == '+'){
                        result = oper1 + oper2; 
                    }else{
                        result = oper1 - oper2; 
                    }
                    sList.set(j-1, Long.toString(result));
                    sList.remove(j);//두개 지움.
                    sList.remove(j);
                    j--;
                }    
            }
        }
        Long answer = Long.parseLong(sList.get(0));
        return Math.abs(answer);
    }
    private void parsing(){
        StringTokenizer st = new StringTokenizer(s,"-+*",true);
        int cnt = st.countTokens();
        for(int i=0;i<cnt;i++){
            aList.add(st.nextToken());
        }
    }
}