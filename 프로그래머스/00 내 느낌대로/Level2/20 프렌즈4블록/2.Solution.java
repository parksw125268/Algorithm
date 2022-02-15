import java.util.*;
class Solution {
    int r, c;
    char[][] field;
    int eraseCnt;
    ArrayList<Integer> eraseList = new ArrayList<>();
    public int solution(int m, int n, String[] board) { //m = r, n = c //지운것 '1'// 빈칸 '0'
        r = m;
        c = n;
        field = new char[r][c];
        parsing(board);//field에 넣기 
       while(true){
            eraseList.clear();
            erase(); //지우기
            down(); //아래로 내리기
            if(eraseList.size() == 0){ break; }
       }
        
        int answer  = counting();//몇개인지 새기 
        return answer;
    }
    private int counting(){
        int cnt = 0;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if(field[i][j] == '0'){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    private void down(){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(field[i][j] == '1'){
                    for(int k=i;k >= 0;k--){
                        if(k == 0){
                            field[k][j] = '0';    
                        }else{
                            field[k][j] = field[k-1][j];    
                        }
                    }
                }
            }
        }    
    }
    
    private void erase(){
        for(int i=0;i<r-1;i++){
            for(int j=0;j<c-1;j++){
                if(field[i][j] == field[i+0][j+1] &&
                   field[i][j] == field[i+1][j+1] &&
                   field[i][j] == field[i+1][j+0] &&
                   field[i][j] != '1' && field[i][j] != '0'){ 
                    eraseList.add(i);
                    eraseList.add(j);
                }  
                   
            }
        }
        for(int i=0;i<eraseList.size();i+=2){
            int y = eraseList.get(i);
            int x = eraseList.get(i+1);
            field[y][x] = '1'; 
            field[y+0][x+1] = '1'; 
            field[y+1][x+1] = '1'; 
            field[y+1][x+0] = '1'; 
        }
    }
    
    private void parsing(String[] board){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                field[i][j] = board[i].charAt(j);
            }
        }
    }
}
