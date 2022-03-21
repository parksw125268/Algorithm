import java.util.*;
class Solution {
    int k; int[][] dungeons;
    int[][] selected;
    int[] used;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        this.k=k; this.dungeons=dungeons;
        this.selected = new int[dungeons.length][2];
        this.used = new int[dungeons.length];
        Arrays.fill(used,0);
        work(0);
        return answer;
    }
    int getAbleCnt(int[][] arr){
        int health = k;
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(health < arr[i][0]){ //던전 입장 가능 확인
                break;
            }
            health -= arr[i][1];
            cnt++;
        }
        return cnt;
    }
    void work(int idx){
        if( idx == dungeons.length ){
            System.out.println(getAbleCnt(selected));
            answer = Math.max(answer,getAbleCnt(selected));
            //System.out.println(Arrays.toString(selected));
            return;
        }
        for(int i=0;i<dungeons.length;i++){
            if(used[i]==0){
                used[i] = 1;
                    selected[idx] = dungeons[i];
                    work(idx+1);
                used[i] = 0;
            }
        }
    }
}