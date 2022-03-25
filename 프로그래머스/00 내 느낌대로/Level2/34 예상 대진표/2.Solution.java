class Solution{
    public int solution(int n, int a, int b){
        int c = a<b ? a:b;
        int d = a<b ? b:a;
        int answer = 1;
        while(!(c%2 == 1 && c+1 == d)){
            answer++;
            c = c/2+c%2;
            d = d/2+d%2;
        }
        return answer;
    }
}