class Solution {
    public String solution(int a, int b) {
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        //1월1일이 금요일 = 나머지가 0일때 목요일, 1일때 금요일. 그러므로 0번째에는 목요일이 들어간다. 
        String[] yoil = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        
        int days = 0;
        for (int i=0;i<a-1;i++){
            days += month[i];
        }
        days += b;
        String answer = "";
        answer = yoil[days % 7];
                
        return answer;
    }
}