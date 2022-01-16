import java.util.*;
class Solution {
    int rows;
    int columns;
    int[][] arr;
    int[] minValue;
    public int[] solution(int rows, int columns, int[][] queries) {
        this.minValue = new int[queries.length];
        this.rows = rows;
        this. columns = columns;
        arr = new int[rows][columns];
        init();

        for(int i=0;i<queries.length;i++){
            rotation(queries[i],i);
        }
        return minValue;
    }
    private void rotation(int[] q,int idx){
        int y1 = q[0]-1;
        int x1 = q[1]-1;
        int y2 = q[2]-1;
        int x2 = q[3]-1;
        int min = Integer.MAX_VALUE;
        //System.out.println(y1+" "+x1+" "+y2+" "+x2);
        int upright = arr[y1][x2];
        for(int i=x2;i>x1;i--){
            arr[y1][i]=arr[y1][i-1];
            min = Math.min(min, arr[y1][i]);
        }
        int downright = arr[y2][x2];
        for(int i=y2;i>y1;i--){
            if(i == y1+1){
                arr[i][x2] = upright;
                min = Math.min(min, arr[i][x2]);
            }else {
                arr[i][x2] = arr[i - 1][x2];
                min = Math.min(min, arr[i][x2]);
            }
        }
        int downleft = arr[y2][x1];
        for(int i=x1;i<x2;i++){
            if(i == x2-1){
                arr[y2][i] = downright;
                min = Math.min(min, arr[y2][i]);
            }else {
                arr[y2][i] = arr[y2][i + 1];
                min = Math.min(min, arr[y2][i]);
            }
        }

        for(int i=y1;i<y2;i++){
            if(i == y2-1){
                arr[i][x1] = downleft;
                min = Math.min(min,arr[i][x1] );
            }else {
                arr[i][x1] = arr[i + 1][x1];
                min = Math.min(min, arr[i][x1]);
            }
        }
        minValue[idx] = min;
    }

    private void init(){
        for(int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                arr[i][j] = columns*i +j+1;
            }
        }
    }
}