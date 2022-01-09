class Solution {
    public int solution(int[][] sizes) {
        //세로가 가로보다 긴 경우 swap.
        //가로의 최대 * 세로의 최대
        int w = Integer.MIN_VALUE;
        int h = Integer.MIN_VALUE;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0] < sizes[i][1]){
                swap(i,sizes);
            }
            w =  Math.max(w,sizes[i][0]);
            h = Math.max(h,sizes[i][1]);
        }
        int answer = w*h;
        return answer;
    }
    private void swap(int row, int[][] array){
        int a = array[row][0];
        array[row][0] = array[row][1];
        array[row][1] = a;
    }
    
}