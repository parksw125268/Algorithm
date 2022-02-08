import java.util.*;
class Solution {
    private ArrayList<Integer> aList = new ArrayList<>();
    private int[] used;
    private int distance = 0;
    private int leng ;
    private int minDistance = Integer.MAX_VALUE;
    private String a = "";
    
    public int solution(String name) {
       
        leng = name.length();
        int upDownCnt = 0;
        for(int i=0;i<leng;i++){
            upDownCnt += getUpDownCnt(name.charAt(i));
            if(i > 0 && name.charAt(i) != 'A'){
                aList.add(i);
            }
        }
        used = new int[aList.size()];
        dfs(0,0);
        return minDistance + upDownCnt;
    }
    
    
    private void dfs(int idx, int before){
        if(idx == aList.size()){
            minDistance = Math.min(minDistance,distance);
            return;
        }
        
        for(int i=0;i<aList.size();i++){
            if(used[i] == 0){
                used[i] = 1;
                int dist = getDistance(before, aList.get(i));
                distance += dist;
                dfs(idx +1, aList.get(i));
                distance -= dist;
                used[i] = 0;
            }
        }
    }
    private int getDistance(int from, int to){ 
        int a, b;
        if(from < to){
            a = from;
            b = to;
        }else{
            a = to;
            b = from;
        }
        int min = Math.min(Math.abs(a-b) , Math.abs(a + (leng-b) )) ;  
        return min;         
    }
    
    private int getUpDownCnt(char c){
        if(c <= 'N'){
            return (c-'A');
        }else{
            return ('Z' - c + 1);
        }
    }
}