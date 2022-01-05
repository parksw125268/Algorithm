import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayList<Integer> aList = new ArrayList<>();
        int bumbCnt = 0;
        for(int i=0;i<moves.length;i++){
            int picked = 0;
            for(int j=0;j<board.length;j++){
                if(board[j][moves[i]-1] != 0){
                    picked = board[j][moves[i]-1]; 
                    board[j][moves[i]-1] = 0;
                    break;
                }                
            }    
            if(picked != 0){//골랐다.
                aList.add(picked);
                if(bumb(aList)){
                    bumbCnt += 2;    
                }
            }
        }
        return bumbCnt;
    }
    private boolean bumb(ArrayList<Integer> list){
        if (list.size() < 2){
            return false;
        }
        if(list.get(list.size()-2) == list.get(list.size()-1)){
            list.remove(list.size()-1);
            list.remove(list.size()-1);
            return true;
        }else{
            return false;
        }
        
    }
}