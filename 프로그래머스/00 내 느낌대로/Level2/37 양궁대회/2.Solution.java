import java.util.*;
class Solution {
    int n; int[] info;
    int scores[]; 
    int[] answer = new int[11];
    int maxDiff = 0;
    public int[] solution(int n, int[] info) {
        this.n = n; this.info =info;
        init();
        work(0,0);
        if(maxDiff == 0){
            int[] answer = {-1};
            return answer;    
        } 
        return answer;
    }
    void getLionPoint(){
        int[] lionPoints = new int[11]; 
        int lionPoint=0;
        int mugePoint=0;
        for(int p : scores) lionPoints[10-p]++; 
        for(int i=0;i<11;i++){
            if(lionPoints[i] > info[i]){
                lionPoint += (10-i);
            }else{
                if(info[i]== 0) continue; 
                mugePoint += (10-i);
            }
        }
        
        if(lionPoint <= mugePoint) return;
        if(maxDiff == 0){  //최초
            maxDiff = lionPoint - mugePoint;
            answer = lionPoints; 
            return;
        }
        if(maxDiff < lionPoint - mugePoint){
            maxDiff = lionPoint - mugePoint;
            answer = lionPoints;
        }else if (maxDiff == lionPoint - mugePoint){
            compareSamePoint(lionPoints);   
        }
    }
    void compareSamePoint(int[] target){
        for(int i=10;i>=0;i--){
            if(target[i] > answer[i]){
                answer = target;
                return;
            }else if (target[i] < answer[i]){
                return;
            }
        }
    }
    void work(int idx,int startIdx){
        if(idx == n){
            getLionPoint();
            return;
        }
        for(int i=startIdx;i<11;i++){
            scores[idx] = i;
            work(idx+1,i);
        }
    }
    void init(){
        scores = new int[n];
    }
}