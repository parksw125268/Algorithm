class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int dcCnt = 0; //당첨된 번호 개수
        int zeroCnt = 0; //낙서된 번호의 개수 
        int[] rank = {6,6,5,4,3,2,1}; //0,1개맞으면 6등, 2개 맞으면 5등...
        
        for (int i=0;i<6;i++){
            if(lottos[i]==0){
                zeroCnt++;
                continue;
            }
            for (int j=0;j<6;j++){
                if(win_nums[j] == lottos[i]){
                    dcCnt++;                    
                }
            }
        }
        int[] answer = {rank[dcCnt+zeroCnt],rank[dcCnt]};
        
        
        return answer;
    }
}