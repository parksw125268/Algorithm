class Solution {
    public int solution(String s) {
        String[] numTable = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i=0;i<numTable.length;i++){
            s = s.replace(numTable[i],Integer.toString(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}